package com.teapayment.challenge.service.interfaces;

import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.model.Subscription;

public interface SubscriptionService {
    Subscription saveSubscription(SubscriptionRequest subscriptionRequest);
    void send(String publicationId);
}
