package com.teapayment.emailservice.config.interfaces;

public interface EmailSubscriber {
    void receiveSendEmailEvent(String payload);
}
