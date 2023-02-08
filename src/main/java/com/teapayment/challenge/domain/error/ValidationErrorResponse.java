package com.teapayment.challenge.domain.error;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorResponse {
    private List<ValidationError> errors = new ArrayList<>();

    public void addValidationError(String field, String message) {
        errors.add(new ValidationError(field, message));
    }

}