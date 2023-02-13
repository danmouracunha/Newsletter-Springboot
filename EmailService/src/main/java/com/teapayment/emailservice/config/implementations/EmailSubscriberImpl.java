package com.teapayment.emailservice.config.implementations;

import com.teapayment.emailservice.config.interfaces.EmailSubscriber;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailSubscriberImpl implements EmailSubscriber {
    @Override
    @RabbitListener(queues = "${mq.queue.send-email}")
    public void receiveSendEmailEvent(@Payload String payload) {
        System.out.println("Email sent to: "+ payload);
    }
}
