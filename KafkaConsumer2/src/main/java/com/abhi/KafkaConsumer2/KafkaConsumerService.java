package com.abhi.KafkaConsumer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "TopicA", groupId = "ConsumerGroup2")
    public void readMessage(String message) {
        System.out.println("TopicA, ConsumerGroup2, message = " + message);
    }
}
