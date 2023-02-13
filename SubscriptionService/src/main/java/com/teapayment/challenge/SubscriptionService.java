package com.teapayment.challenge;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableRabbit
@EnableEurekaClient
@SpringBootApplication
public class SubscriptionService {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionService.class, args);
	}

}
