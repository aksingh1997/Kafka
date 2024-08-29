package com.abhi.KafkaProducer.Controller;

import com.abhi.KafkaProducer.service.KafkaProducerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @GetMapping("/kafka/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message) {
        String topicName = "TopicA";
        kafkaProducerService.sendMessage(topicName, message);
        return ResponseEntity.ok("message sent successfully");
    }
}
