package com.example.kafkaproducer.config;


import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class KafkaTopicProperties {

	private final MyKafkaProperties myKafkaProperties;


	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> config = new HashMap<>();

		config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, myKafkaProperties.getBootstrapKafkaAddress());
		return new KafkaAdmin(config);
	}

	@Bean
	NewTopic newTopic() {
		return new NewTopic(myKafkaProperties.getTopic(), 1, (short) 1);
	}
}
