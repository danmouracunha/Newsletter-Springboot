package com.teapayment.emailservice.service.implementation;

import com.teapayment.emailservice.domain.Email;
import lombok.RequiredArgsConstructor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import com.teapayment.emailservice.service.interfaces.EmailService;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailServiceLocal implements EmailService {
    private final JavaMailSender javaMailSender;

    private String sender;
    @Value("${email.test}")
    private String emailTest;

    @Override
    public void sendEmail(Email email) throws MessagingException {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            mailMessage.setSubject(email.getSubject());
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
            helper.setFrom("sender@oi.com");
            helper.setTo(emailTest);
            helper.setText(email.getMessage(), true);

            javaMailSender.send(mailMessage);
            log.info("The email was sent");
        } catch (Exception e) {
//            log.error("Error sending email={}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void sendNewsletterEmail(String destinatary) throws MessagingException {
        String template = "Hello :)";
        System.out.println(template);
        Email email = Email.builder()
                .subject("Newsletter [014]: Hello")
                .destinatary(destinatary)
                .message(template)
                .build();

        sendEmail(email);
    }

}
