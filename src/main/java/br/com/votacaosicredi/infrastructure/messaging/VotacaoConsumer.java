package br.com.votacaosicredi.infrastructure.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VotacaoConsumer {

	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(final ConsumerRecord<String, VotacaoRequestDTO> consumer) {
		log.info("Topico: " + consumer.topic());
		log.info("Partição: " + consumer.partition());
		log.info("Mensagem recebida no tópico VOTO: " + consumer.value());
	}
}
