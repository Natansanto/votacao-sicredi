package br.com.votacaosicredi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacaosicredi.infrastructure.entity.VotoEntity;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Long> {

	VotoEntity findByNomeAndCpf(String nome, String cpf);

	long countByNome(String nome);
}
