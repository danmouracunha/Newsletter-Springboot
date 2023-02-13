package com.teapayment.challenge.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmailToSubscriberDTO {
    String email;
    UUID publicationId;
}
