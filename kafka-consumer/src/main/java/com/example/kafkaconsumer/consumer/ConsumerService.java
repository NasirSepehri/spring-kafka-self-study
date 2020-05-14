package com.example.kafkaconsumer.consumer;

import com.example.kafkaconsumer.config.MyKafkaProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ConsumerService {

	@KafkaListener(topics= "nasir",groupId = MyKafkaProperties.CONSUMER_GROUP_ID)
	public void consumer(String message){
		log.info("CONSUMER: We received a message!!! {}", message);
	}
}
