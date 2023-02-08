package com.teapayment.challenge.service.implementations;

import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.model.Subscription;
import com.teapayment.challenge.repository.SubscriptionRepository;
import com.teapayment.challenge.service.interefaces.SubscriptionService;
import jdk.jshell.JShell;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    public Subscription saveSubscription(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = Subscription.builder()
                .firstName(subscriptionRequest.getFirstName())
                .email(subscriptionRequest.getEmail())
                .dateOfBirth(subscriptionRequest.getDateOfBirth())
                .consent(subscriptionRequest.isConsent())
                .gender(subscriptionRequest.getGender())
                .build();
        return subscriptionRepository.save(subscription);
    }
}
