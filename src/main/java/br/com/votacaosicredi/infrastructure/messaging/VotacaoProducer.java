package br.com.votacaosicredi.infrastructure.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VotacaoProducer {

	@Value("${topic.name.producer}")
	private String topic;
	private final KafkaTemplate<String, VotacaoRequestDTO> kafkaTemplate;

	public void send(VotacaoRequestDTO voto) {
		log.info("Voto enviado: {}", voto);
		kafkaTemplate.send(topic, voto);
	}
}
