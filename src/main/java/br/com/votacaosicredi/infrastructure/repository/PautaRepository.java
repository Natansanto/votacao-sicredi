package br.com.votacaosicredi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.votacaosicredi.infrastructure.entity.PautaEntity;

@Repository
public interface PautaRepository extends JpaRepository<PautaEntity, Long> {
	
	 boolean existsByNome(String nome);
}
