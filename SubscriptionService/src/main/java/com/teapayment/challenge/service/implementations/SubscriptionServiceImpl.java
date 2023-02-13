package com.teapayment.challenge.service.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teapayment.challenge.domain.dto.EmailToSubscriberDTO;
import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.model.Subscription;
import com.teapayment.challenge.messages.interfaces.EmailSubscriberPublisher;
import com.teapayment.challenge.repository.SubscriptionRepository;
import com.teapayment.challenge.service.interfaces.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final EmailSubscriberPublisher emailSubscriberPublisher;
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
    public void send(String publicationId){
        List<Subscription> all = subscriptionRepository.findAll();
        all.forEach(subscription -> {
            try {
                emailSubscriberPublisher.requestEmail(EmailToSubscriberDTO.builder().email(subscription.getEmail()).publicationId(UUID.fromString(publicationId )).build());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
