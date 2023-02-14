package com.teapayment.challenge.domain.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class SubscriptionRequest {
    @Email
    @NotNull
    private String email;
    private String firstName;
    private Gender gender;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private Boolean consent;
    @NotNull
    private UUID newsletterId;
}
