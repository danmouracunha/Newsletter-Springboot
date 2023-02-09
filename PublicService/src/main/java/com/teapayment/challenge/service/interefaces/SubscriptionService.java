package com.teapayment.challenge.service.interefaces;

import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.model.Subscription;

public interface SubscriptionService {
    public Subscription saveSubscription(SubscriptionRequest subscriptionRequest);
}
