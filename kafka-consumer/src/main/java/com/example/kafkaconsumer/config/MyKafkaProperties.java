package com.example.kafkaconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mykafka")
@Data
public class MyKafkaProperties {
	public static final String CONSUMER_GROUP_ID = "nasirsconsumergroup";
	private String bootstrapAddress;

}
