package com.abhi.KafkaConsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer1Application.class, args);
		System.out.println("Hello I am consumer1");
	}

}
