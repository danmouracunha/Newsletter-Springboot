package com.teapayment.emailservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmailToSubscriberDTO {
    String email;
    UUID publicationId;
}
