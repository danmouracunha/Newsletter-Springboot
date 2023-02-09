package com.teapayment.challenge.controller.v1;

import com.teapayment.challenge.domain.dto.SubscriptionRequest;
import com.teapayment.challenge.domain.error.ValidationErrorResponse;
import com.teapayment.challenge.service.interefaces.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;


    @PostMapping
    public ResponseEntity<SubscriptionRequest> makeSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        subscriptionService.saveSubscription(subscriptionRequest);
        return ResponseEntity.ok(subscriptionRequest);
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
