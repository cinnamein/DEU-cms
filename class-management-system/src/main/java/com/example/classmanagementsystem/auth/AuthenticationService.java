package com.example.classmanagementsystem.auth;

import com.example.classmanagementsystem.user.entity.Student;
import com.example.classmanagementsystem.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.util.Random;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JavaMailSender emailSender;

    private final RedisService redisService;

    private final UserRepository userRepository;

    /**
     * 생성된 인증 메일을 전송
     *
     * @param email
     * @param title
     * @param content
     */
    public void sendEmail(String email, String title, String content) {
        SimpleMailMessage emailForm = createEmailForm(email, title, content);
        try {
            emailSender.send(emailForm);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 인증 메일 생성
     *
     * @param email
     * @param title
     * @param content
     * @return message
     */
    private SimpleMailMessage createEmailForm(String email, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(title);
        message.setText(content);
        return message;
    }

    /**
     * 인증번호 전송
     *
     * @param email
     */
    public void sendCodeToEmail(String email) {
        checkDuplicatedEmail(email);
        String title = "email 인증 번호";
        String authCode = createCode();
        sendEmail(email, title, authCode);
        redisService.setValues(email, authCode);
    }

    /**
     * 인증번호 생성
     *
     * @return builder
     */
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

    /**
     * 중복된 이메일은 아닌지 확인
     *
     * @param email
     */
    private void checkDuplicatedEmail(String email) {
        Mono<Student> student = userRepository.findByEmail(email);
        student.flatMap(student1 -> {
            if (student1.getEmail().equals(email)){
                throw new RuntimeException("잘못된 이메일");
            }
        });
    }



    /**
     * 인증 번호가 맞는지 확인
     *
     * @param email
     * @param authCode
     */
    public boolean checkVerifiedCode(String email, String authCode) {
        checkDuplicatedEmail(email);
        return authCode.equals(redisService.getValues(email));
    }
}
