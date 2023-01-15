package br.com.votacaosicredi.business;

import static br.com.votacaosicredi.utils.Constantes.ERRO_AO_VALIDAR_CPF;
import static java.lang.String.format;

import org.springframework.stereotype.Service;

import br.com.votacaosicredi.exception.NotFoundException;
import br.com.votacaosicredi.infrastructure.client.ApiValidaCpfClient;
import br.com.votacaosicredi.infrastructure.client.dto.ApiValidaCpfResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class ApiValidaCpfService {

	private final ApiValidaCpfClient client;

	public ApiValidaCpfResponseDTO consultarCpf(String cpf)  {
		try {
			return client.validarCpf(cpf);
		} catch (Exception e) {
			log.error(
					format(ERRO_AO_VALIDAR_CPF, e.getMessage()), e
			);
			throw new NotFoundException(
					format(ERRO_AO_VALIDAR_CPF, e.getMessage())
			);	
		}	
	}
}
