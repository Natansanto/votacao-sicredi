package br.com.votacaosicredi.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.votacaosicredi.infrastructure.client.dto.ApiValidaCpfResponseDTO;

@FeignClient(
		name = "validacpf",
		url= "https://user-info.herokuapp.com/users/" 	
)
public interface ApiValidaCpfClient {
	
	@GetMapping("{cpf}")
	ApiValidaCpfResponseDTO validarCpf(@PathVariable("cpf") String cpf);
}
