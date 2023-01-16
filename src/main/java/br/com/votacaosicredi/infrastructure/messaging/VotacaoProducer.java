package br.com.votacaosicredi.infrastructure.messaging;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;
import br.com.votacaosicredi.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VotacaoProducer {

	@Value("${topic.name}")
	private String topic;
	private final KafkaTemplate<String, VotacaoRequestDTO> kafkaTemplate;

	public void send(VotacaoRequestDTO voto) {
		try {
			log.info("Mensagem enviada para o tópico de VOTO: {}", voto);
			kafkaTemplate.send(topic, voto);
		} catch (Exception e) {
			log.error(
					format("Ocorreu um erro ao conectar com kafka.", e)
			);
			throw new InternalServerException(
					format("Ocorreu um erro ao conectar com kafka.", e)
			);
		}
	}
}


