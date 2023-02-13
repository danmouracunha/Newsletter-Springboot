package com.teapayment.emailservice.service.interfaces;

import com.teapayment.emailservice.domain.Email;
import javax.mail.MessagingException;

public interface EmailService {

    void sendEmail(Email email) throws MessagingException;
    void sendNewsletterEmail(String destinatary) throws MessagingException;
}
