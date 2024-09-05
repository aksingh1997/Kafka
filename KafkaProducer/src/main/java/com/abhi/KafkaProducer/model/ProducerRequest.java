package com.abhi.KafkaProducer.model;

import lombok.Data;

@Data
public class ProducerRequest {
    String topic;
    String city;
    String message;
}
