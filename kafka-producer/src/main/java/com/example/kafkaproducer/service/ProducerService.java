package com.example.kafkaproducer.service;

import com.example.kafkaproducer.config.MyKafkaProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerService {

	private static AtomicInteger messageCounter = new AtomicInteger(0);

	private final KafkaTemplate kafkaTemplate;
	private final MyKafkaProperties myKafkaProperties;


	@Scheduled(fixedRate = 1000 * 5)
	public void messageProducer() {
		String message = String.format("hello %d this is a kafka message %s", messageCounter.incrementAndGet(),
				LocalDateTime.now().toString());

		ListenableFuture send = kafkaTemplate.send(myKafkaProperties.getTopic(),message);
		send.addCallback(new ListenableFutureCallback() {
			@Override
			public void onFailure(Throwable ex) {
				log.error("ERROR Kafka error happened", ex);
			}

			@Override
			public void onSuccess(Object result) {
				log.info("SUCCESS!!! This is the result: {}", result);
			}
		});
	}

}
