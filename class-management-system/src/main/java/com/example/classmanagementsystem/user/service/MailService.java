package com.example.classmanagementsystem.user.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class MailService {
    private final JavaMailSender eMailSender;

    public void sendEmail(String email, String title, String content) {
        SimpleMailMessage emailForm = createEmailForm(email, title, content);
        try {
            eMailSender.send(emailForm);
        } catch (RuntimeException e) {
            log.debug("MailService.sendEmail exception occur toEmail: {}, " +
                    "title: {}, text: {}", email, title, content);
            throw new RuntimeException();
        }
    }

    private SimpleMailMessage createEmailForm(String email, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(title);
        message.setText(content);
        return message;
    }
}
