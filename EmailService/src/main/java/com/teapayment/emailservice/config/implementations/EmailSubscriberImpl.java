package com.teapayment.emailservice.config.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teapayment.emailservice.config.interfaces.EmailSubscriber;
import com.teapayment.emailservice.domain.EmailToSubscriberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.teapayment.emailservice.service.interfaces.EmailService;

import javax.mail.MessagingException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailSubscriberImpl implements EmailSubscriber {
    private final EmailService emailService;
    @Override
    @RabbitListener(queues = "${mq.queue.send-email}")
    public void receiveSendEmailEvent(@Payload String payload) {
        var mapper = new ObjectMapper();
        try {
            EmailToSubscriberDTO dados = mapper.readValue(payload, EmailToSubscriberDTO.class);
            emailService.sendNewsletterEmail(dados.getEmail());
            log.info("Email sent to: "+ payload);
        } catch (MessagingException|JsonProcessingException e) {
            log.info("Fail to process: "+ payload);
            throw new RuntimeException(e);
        }
    }
}
