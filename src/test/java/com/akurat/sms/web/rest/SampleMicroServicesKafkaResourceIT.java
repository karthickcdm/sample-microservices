package com.akurat.sms.web.rest;

import com.akurat.sms.SampleMicroServicesApp;
import com.akurat.sms.service.SampleMicroServicesKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = SampleMicroServicesApp.class)
public class SampleMicroServicesKafkaResourceIT {

    @Autowired
    private SampleMicroServicesKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        SampleMicroServicesKafkaResource kafkaResource = new SampleMicroServicesKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/sample-micro-services-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
