package com.example.kafkamicro.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class KafkaMessageListener {

    @Transactional(transactionManager = "tmKafkaMessage", rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    @KafkaListener(topics = "intIn.inner.any.convert", groupId = "your-consumer-group")
    public void listen2(ConsumerRecord<String, String> message) {
        log.info("Init kafka message: " + message.key() + " " + message.value());
        if (message.value().equals("Hello")) {
            log.error("Rollback transaction ");
            throw new RuntimeException();
        } else {
            log.info("Message is ok. Message: {}", message.value());
        }
    }

}

