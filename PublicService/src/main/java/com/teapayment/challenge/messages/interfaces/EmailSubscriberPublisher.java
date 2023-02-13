package com.teapayment.challenge.messages.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teapayment.challenge.domain.dto.EmailToSubscriberDTO;

public interface EmailSubscriberPublisher {
    void requestEmail(EmailToSubscriberDTO emailToSubscriberDTO) throws JsonProcessingException;

}
