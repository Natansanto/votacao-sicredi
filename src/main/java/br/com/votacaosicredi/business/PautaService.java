package br.com.votacaosicredi.business;

import static br.com.votacaosicredi.utils.Constantes.*;
import static java.lang.String.format;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.votacaosicredi.ap1.v1.dto.PautaRequestDTO;
import br.com.votacaosicredi.business.converters.PautaConverter;
import br.com.votacaosicredi.exception.BadRequestException;
import br.com.votacaosicredi.exception.InternalServerException;
import br.com.votacaosicredi.infrastructure.repository.PautaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class PautaService {

	private final PautaRepository repository;
	private final PautaConverter converter;


	@Transactional
	public void salvarPauta(PautaRequestDTO pautaRequestDTO) {
		try {
			repository.save(converter.paraEntidade(pautaRequestDTO));
		} catch (InternalServerException | DataIntegrityViolationException e) {
			log.error(
					format(ERRO_AO_SALVAR_PAUTA, e.getMessage()), e
			);
			throw new InternalServerException(
					format(ERRO_AO_SALVAR_PAUTA, e.getMessage())
			);	
		}
	}
	
	 public void buscarPorNome(String nome) {
	        boolean existeNomePauta = repository.existsByNome(nome.toUpperCase());
	        if(existeNomePauta!=true){
	        	log.error(
						format(PAUTA_NAO_EXISTE, nome)
				);
				throw new BadRequestException(
						format(PAUTA_NAO_EXISTE, nome)
				);
	        }
	    }   
}
