package com.abhi.KafkaConsumer1.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics="TopicA", groupId = "ConsumerGroup1")
    public void readMessage(String message) {
        System.out.println("TopicA, ConsumerGroup1, message = " + message);
    }
}
