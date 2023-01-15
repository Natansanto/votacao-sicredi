package br.com.votacaosicredi.business.converters;

import org.springframework.stereotype.Component;

import br.com.votacaosicredi.ap1.v1.dto.PautaRequestDTO;
import br.com.votacaosicredi.infrastructure.entity.PautaEntity;

@Component
public class PautaConverter {
	
	  public PautaEntity paraEntidade(PautaRequestDTO requestDTO) {
	       return PautaEntity.builder()
	               .nome(requestDTO.getNomePauta().toUpperCase())
	               .build();
	    }    
}
