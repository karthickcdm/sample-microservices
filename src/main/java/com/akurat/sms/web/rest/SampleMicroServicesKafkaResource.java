package com.akurat.sms.web.rest;

import com.akurat.sms.service.SampleMicroServicesKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sample-micro-services-kafka")
public class SampleMicroServicesKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SampleMicroServicesKafkaResource.class);

    private SampleMicroServicesKafkaProducer kafkaProducer;

    public SampleMicroServicesKafkaResource(SampleMicroServicesKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
