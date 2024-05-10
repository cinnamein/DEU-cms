package com.example.classmanagementsystem.auth.service;

import com.example.classmanagementsystem.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JavaMailSender emailSender;
    private final StringRedisTemplate redisTemplate;
    private final UserRepository userRepository;

    /**
     * 인증번호 메일 송신 메서드
     *
     * @param receiver
     */
    public Mono<ServerResponse> sendEmail(long studentId, String receiver) {
        return checkDuplicateStudentId(studentId)
                .flatMap(result -> {
                    SimpleMailMessage message = createEmail(receiver);
                    return Mono.fromRunnable(() -> emailSender.send(message))
                            .then(ServerResponse.ok().bodyValue("이메일 전송 성공"))
                            .onErrorResume(Mono::error);
                });
    }

    /**
     * 이메일 가입 여부 판단 메서드
     *
     * @param receiver
     * @param userCode
     */
    public Mono<ServerResponse> compareVerificationCode(String receiver, String userCode) {
        return Mono.just(getRedisCode(receiver))
                .flatMap(redisCode -> {
                    return Mono.fromRunnable(() -> saveRedisCode(receiver, redisCode))
                            .then(ServerResponse.ok().bodyValue("가입되지 않은 이메일"))
                            .onErrorResume(Mono::error);
                });
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

    private Mono<Boolean> checkDuplicateStudentId(long studentId) {
        return userRepository.existsByStudentId(studentId);
    }
}