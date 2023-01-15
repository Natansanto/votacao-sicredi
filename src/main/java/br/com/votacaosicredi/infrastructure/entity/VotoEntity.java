package br.com.votacaosicredi.infrastructure.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.com.votacaosicredi.infrastructure.enums.VotoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "voto")
public class VotoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false, length = 30)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(name = "voto", nullable = false)
	private VotoEnum voto;

	@Column(name = "data_hora_inclusao")
	private LocalDateTime dataHoraInclusao;

	@PrePersist
	public void prePersist() {
		this.dataHoraInclusao = LocalDateTime.now();
	}
}
