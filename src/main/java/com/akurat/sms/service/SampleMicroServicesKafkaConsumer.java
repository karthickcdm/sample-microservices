package com.akurat.sms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SampleMicroServicesKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(SampleMicroServicesKafkaConsumer.class);
    private static final String TOPIC = "topic_samplemicroservices";

    @KafkaListener(topics = "topic_samplemicroservices", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
