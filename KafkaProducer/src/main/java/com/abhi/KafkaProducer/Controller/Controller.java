package com.abhi.KafkaProducer.Controller;

import com.abhi.KafkaProducer.constants.AppConstants;
import com.abhi.KafkaProducer.model.ProducerRequest;
import com.abhi.KafkaProducer.service.KafkaProducerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/kafka")
public class Controller {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/topic")
    public ResponseEntity<?> sendMessage(@RequestBody ProducerRequest producerRequest) {
        String city = producerRequest.getCity();
        //Optional<Integer> cityCode = Arrays.stream(AppConstants.values()).map(x -> x.name()).filter(producerRequest.getCity()).findAny();
        if(!city.equalsIgnoreCase(AppConstants.Pune.name()) && !city.equalsIgnoreCase(AppConstants.Mumbai.name()) )
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong city input");
        kafkaProducerService.sendMessage(producerRequest.getTopic(), producerRequest.getCity(), producerRequest.getMessage());
        return ResponseEntity.ok("message sent successfully");
    }
}
