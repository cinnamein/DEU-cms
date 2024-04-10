package com.example.classmanagementsystem.user.service;

import com.example.classmanagementsystem.user.entity.Student;
import com.example.classmanagementsystem.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class UserService {

    private final EmailService emailService;

    private final UserRepository userRepository;

    /**
     * 인증번호 전송
     * @param email
     */
    public void sendCodeToEmail(String email) {
        if (!checkDuplicatedEmail(email)) {
            String title = "email 인증 번호";
            String authCode = createCode();
            emailService.sendEmail(email, title, authCode);
            // TODO: 코드를 서버에 저장
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * 중복된 이메일은 아닌지 확인
     * @param email
     * @return student.isEmpty()
     */
    private boolean checkDuplicatedEmail(String email) {
        Optional<Student> student = userRepository.findByEmail(email);
        return student.isEmpty();
    }


    /**
     * 인증번호 생성
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
}
