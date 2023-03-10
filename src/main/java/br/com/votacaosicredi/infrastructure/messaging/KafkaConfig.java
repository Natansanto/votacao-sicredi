package br.com.votacaosicredi.infrastructure.messaging;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import br.com.votacaosicredi.ap1.v1.dto.VotacaoRequestDTO;

@Configuration
public class KafkaConfig {

	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapServers;

	@Value(value = "${topic.name}")
	private String topic;

	@Bean
	public NewTopic createTopic() {
		return new NewTopic(topic, 3, (short) 1);
	}
	
	// PRODUCER
	@Bean
	public KafkaTemplate<String, VotacaoRequestDTO> carafkaTemplate() {
		return new KafkaTemplate<>(CarProducerFactory());
	}

	@Bean
	public ProducerFactory<String, VotacaoRequestDTO> CarProducerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(props);
	}
	
	// CONSUMER
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, VotacaoRequestDTO> KafkaFactory() {
		ConcurrentKafkaListenerContainerFactory<String, VotacaoRequestDTO> factory = new ConcurrentKafkaListenerContainerFactory<String, VotacaoRequestDTO>();

		factory.setConsumerFactory(consumer());

		return factory;
	}

	private ConsumerFactory<String, VotacaoRequestDTO> consumer() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return new DefaultKafkaConsumerFactory<>(props);
	}

}
