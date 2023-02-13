package com.teapayment.challenge.controller.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teapayment.challenge.domain.dto.EmailToSubscriberDTO;
import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.error.ValidationErrorResponse;
import com.teapayment.challenge.domain.model.Subscription;
import com.teapayment.challenge.service.interfaces.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;


    @PostMapping
    public ResponseEntity<Subscription> makeSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionService.saveSubscription(subscriptionRequest);
        return ResponseEntity.ok(subscription);
    }

    @PatchMapping("/{newsletterId}/publication/{publicationId}")
    public void receiveNewNewsletterPublication(@PathVariable(name = "newsletterId") String newsletterId, @PathVariable(name = "publicationId") String publicationId){
        // TODO document why this method is empty
        subscriptionService.send(publicationId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        ValidationErrorResponse errors = new ValidationErrorResponse();
        for (FieldError fieldError : fieldErrors) {
            errors.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
