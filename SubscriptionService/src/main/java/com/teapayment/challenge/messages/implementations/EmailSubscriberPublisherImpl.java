package com.teapayment.challenge.messages.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teapayment.challenge.messages.config.MQConfig;
import com.teapayment.challenge.messages.interfaces.EmailSubscriberPublisher;
import com.teapayment.challenge.domain.dto.EmailToSubscriberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSubscriberPublisherImpl implements EmailSubscriberPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    @Override
    public void requestEmail(EmailToSubscriberDTO emailToSubscriberDTO) throws JsonProcessingException {
        var json = emailToSubscriberDTOToJSONString(emailToSubscriberDTO);
        rabbitTemplate.convertAndSend(queue.getName(),json);
    }

    private String emailToSubscriberDTOToJSONString(EmailToSubscriberDTO emailToSubscriberDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(emailToSubscriberDTO);
    }
}
