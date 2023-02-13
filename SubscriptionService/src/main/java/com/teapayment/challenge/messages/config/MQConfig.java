package com.teapayment.challenge.messages.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MQConfig {
    @Value("${mq.queue.send-email}")
    private String sendEmailQueueName;
    @Bean
    public Queue queueSendEmail(){
        return new Queue(sendEmailQueueName, true);
    }
}
