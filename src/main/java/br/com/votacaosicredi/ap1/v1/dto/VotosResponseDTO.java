package br.com.votacaosicredi.ap1.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotosResponseDTO {

	private String nomePauta;
	private Long quantidade;
}
