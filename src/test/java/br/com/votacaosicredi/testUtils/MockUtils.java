package br.com.votacaosicredi.testUtils;

import java.time.LocalDateTime;

import br.com.votacaosicredi.ap1.v1.dto.PautaRequestDTO;
import br.com.votacaosicredi.infrastructure.entity.PautaEntity;

public class MockUtils {
	
	public static final long ID = 1L;
	public static final String NOME = "voto 2";
    public static final LocalDateTime DATA_HORA_INCLUSAO = LocalDateTime.of(2022, 9, 12, 9, 9, 10);

	public static PautaEntity buildPauta() {
        
		return PautaEntity.builder()
                .id(ID)
                .nome(NOME)             
                .dataHoraInclusao(DATA_HORA_INCLUSAO)               
                .build();
    }
	
    public static PautaRequestDTO buildPautaRequestDTO() {

        return PautaRequestDTO.builder()      
                .nomePauta(NOME)             
                .build();
    }	
}
