package com.teapayment.challenge.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherNotificationDTO {
    String email;
    UUID newsletterId;
    UUID publicationId;
}
