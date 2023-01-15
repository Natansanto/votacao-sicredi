package br.com.votacaosicredi.business.converters;

import org.springframework.stereotype.Component;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import br.com.votacaosicredi.ap1.v1.dto.VotacaoResponseDTO;
import br.com.votacaosicredi.ap1.v1.dto.VotosResponseDTO;
import br.com.votacaosicredi.infrastructure.entity.VotoEntity;

@Component
public class VotacaoConverter {

    public VotoEntity paraEntidadeVoto(VotacaoRequestDTO requestDTO) {
        return VotoEntity.builder()
                .nome(requestDTO.getNomePauta().toUpperCase())
                .cpf(requestDTO.getCpf())
                .voto(requestDTO.getVoto())
                .build();
     }
    
    public VotacaoResponseDTO paraDTO(Long quantidade, String nome) {
        return VotacaoResponseDTO.builder()
                .votos(VotosResponseDTO.builder()
                .nomePauta(nome)
                .quantidade(quantidade)
                .build())
                .build();
    }
}