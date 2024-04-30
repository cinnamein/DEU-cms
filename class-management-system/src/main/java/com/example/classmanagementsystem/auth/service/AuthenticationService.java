package com.example.classmanagementsystem.auth.service;

import com.example.classmanagementsystem.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JavaMailSender emailSender;
    private final StringRedisTemplate redisTemplate;
    private final UserRepository userRepository;

    /**
     * 인증번호 메일 송신 메서드
     * @param receiver
     */
    public void sendEmail(String receiver) {
        if (checkDuplicateEmail(receiver)) {
            throw new RuntimeException();
        }
        SimpleMailMessage message = createEmail(receiver);
        try {
            emailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 이메일 가입 여부 판단 메서드
     * @param receiver
     * @param userCode
     */
    public void compareVerificationCode(String receiver, String userCode) {
        String redisCode = getRedisCode(receiver);
        if (!userCode.equals(redisCode)) {
            throw new RuntimeException();
        }
        saveRedisCode(receiver, redisCode);
    }

    private SimpleMailMessage createEmail(String receiver) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiver);
        message.setSubject("인증 코드");
        String code = createCode();
        message.setText(code);
        return message;
    }

    private String createCode() {
        int length = 6;
        try {
            Random random = SecureRandom.getInstanceStrong();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(random.nextInt(10));
            }
            return builder.toString();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private void saveRedisCode(String receiver, String redisCode) {
        redisTemplate.opsForValue().set(receiver, redisCode);
    }

    private String getRedisCode(String receiver) {
        return redisTemplate.opsForValue().get(receiver);
    }

    private boolean checkDuplicateEmail(String receiver) {
        return userRepository.existsByEmail(receiver);
    }
}