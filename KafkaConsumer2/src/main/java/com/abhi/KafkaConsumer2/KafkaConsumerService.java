package com.abhi.KafkaConsumer2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    // this will read from topic = Cities and partition = 0
    @KafkaListener(topicPartitions = @TopicPartition(topic = "Cities", partitions = {"0"}), groupId = "ConsumerGroup2")
    public void readMessage1(String message) {
        String consumerName = "Consumer1";
        System.out.println(consumerName + " message = " + message);
    }

    // this will read from topic = Cities and partition = 1
    @KafkaListener(topicPartitions = @TopicPartition(topic = "Cities", partitions = {"1"}), groupId = "ConsumerGroup2")
    public void readMessage2(String message) {
        String consumerName = "Consumer2";
        System.out.println(consumerName + " message = " + message);
    }
}
