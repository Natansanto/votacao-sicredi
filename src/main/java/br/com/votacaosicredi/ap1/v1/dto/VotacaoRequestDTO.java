package br.com.votacaosicredi.ap1.v1.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.votacaosicredi.infrastructure.enums.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoRequestDTO {

    @NotBlank(message = "Nome da pauta é obrigatório.")
    @Size(max = 30, message = "Nome deve ter no máximo 30 caracteres.")
	private String nomePauta;

	@NotNull
	private VotoEnum voto;

	@NotNull
	private String cpf;
}
