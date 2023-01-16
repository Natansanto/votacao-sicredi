package br.com.votacaosicredi.business;

import static br.com.votacaosicredi.utils.Constantes.*;
import static java.lang.String.format;

import java.util.Objects;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import br.com.votacaosicredi.ap1.v1.dto.VotacaoResponseDTO;
import br.com.votacaosicredi.business.converters.VotacaoConverter;
import br.com.votacaosicredi.exception.BadRequestException;
import br.com.votacaosicredi.exception.InternalServerException;
import br.com.votacaosicredi.exception.NotFoundException;
import br.com.votacaosicredi.infrastructure.client.dto.ApiValidaCpfResponseDTO;
import br.com.votacaosicredi.infrastructure.entity.VotoEntity;
import br.com.votacaosicredi.infrastructure.messaging.VotacaoProducer;
import br.com.votacaosicredi.infrastructure.repository.VotoRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class VotacaoService {

	private final VotoRepository repository;
	private final PautaService pautaService;
	private final ApiValidaCpfService apiValidaCpfService;
	private final VotacaoConverter converter;
	private final VotacaoProducer votacaoProducer;

	@Transactional(timeout = 100)
	public void salvarVotacao(VotacaoRequestDTO votacaoRequestDTO) {
		try {
			
			//FAZ A CHAMADA PARA A API EXTERNA NO QUAL VALIDA O CPF 
			//VOU DEIXAR COMENTADO POIS A API PROVAVELMENTE ESTÁ FORA (erro 404), MAS O FLUXO SERIA ESSE
			//validarCpf(votacaoRequestDTO.getCpf());
			
			pautaService.buscarPorNome(votacaoRequestDTO.getNomePauta());
			buscarPorNomeEhCpf(votacaoRequestDTO.getCpf(), votacaoRequestDTO.getNomePauta());
			repository.save(converter.paraEntidadeVoto(votacaoRequestDTO));
			
			//PRUDUZIR UMA MENSAGEM PARA O NOSSO TOPICO E FAZ O ENVIO DIRETO
			votacaoProducer.send(votacaoRequestDTO);
		} catch (InternalServerException | DataIntegrityViolationException e) {
			log.error(
					format(ERRO_AO_SALVAR_VOTO, e.getMessage()), e
			);
			throw new InternalServerException(
					format(ERRO_AO_SALVAR_VOTO, e.getMessage())
			);	
		}
	}
	
	public void validarCpf(String cpf) {
		ApiValidaCpfResponseDTO dtoCpf = apiValidaCpfService.consultarCpf(cpf);;
		if (dtoCpf.getStatus().contains("UBABLE_TO_VOTE")) {
			log.error(
					format(CPF_INVALIDO, cpf)
			);
			throw new BadRequestException(
					format(CPF_INVALIDO, cpf)
			);
		}
	}

	public void buscarPorNomeEhCpf(String cpf, String nome) {
		VotoEntity temVoto = repository.findByNomeAndCpf(nome.toUpperCase(), cpf);	
		if (Objects.nonNull(temVoto)) {
			log.error(
					format(VOTO_JA_CADASTRADO, cpf, nome)
			);
			throw new BadRequestException(
					format(VOTO_JA_CADASTRADO, cpf, nome)
			);
		}
	}

	public VotacaoResponseDTO buscarVotos(String nome) {
		long votos = repository.countByNome(nome.toUpperCase());	
	    if (Objects.isNull(votos)) {
	    	log.error(
					format(ERRO_AO_BUSCAR_VOTOS, nome)
			);
	        throw new NotFoundException(
	        		format(ERRO_AO_BUSCAR_VOTOS, nome)
	        );
	     }
	    return converter.paraDTO(votos, nome);	
	}
}