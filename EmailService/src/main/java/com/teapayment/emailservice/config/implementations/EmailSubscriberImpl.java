package com.teapayment.emailservice.config.implementations;

import com.teapayment.emailservice.config.interfaces.EmailSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.teapayment.emailservice.service.interfaces.EmailService;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor
public class EmailSubscriberImpl implements EmailSubscriber {
    private final EmailService emailService;
    @Override
    @RabbitListener(queues = "${mq.queue.send-email}")
    public void receiveSendEmailEvent(@Payload String payload) {
        try {
            emailService.sendNewsletterEmail("damouracunha@gmail.com");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email sent to: "+ payload);
    }
}
