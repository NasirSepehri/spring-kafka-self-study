package com.example.kafkaproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mykafka")
public class MyKafkaProperties {
	private String bootstrapKafkaAddress;
	private String topic;
}
