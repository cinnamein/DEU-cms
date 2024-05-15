package com.example.classmanagementsystem.user.service;

import com.example.classmanagementsystem.user.model.EditProfileRequest;
import com.example.classmanagementsystem.user.model.Student;
import com.example.classmanagementsystem.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public Mono<Student> register(ServerRequest request) {
        return request.bodyToMono(Student.class)
                .flatMap(data -> {
                    return userRepository.existsByStudentId(data.getStudentId())
                            .flatMap(result -> {
                                if (!result) {
                                    Student student = new Student();
                                    student.setStudentId(data.getStudentId());
                                    student.setPassword(passwordEncoder.encode(data.getPassword()));
                                    student.setName(data.getName());
                                    student.setEmail(data.getEmail());
                                    student.setGrade(data.getGrade());

                                    return userRepository.save(student);
                                } else {
                                    return Mono.error(new Exception("이미 존재하는 학번"));
                                }
                            });
                })
                .onErrorResume(NoSuchElementException.class, error -> Mono.error(new Exception("사용자를 찾을 수 없음")));
    }

    public Mono<Student> login(long studentId, String password) {
        return userRepository.findByStudentId(studentId)
                .flatMap(data -> {
                    if (passwordEncoder.matches(password, data.getPassword())) {
                        return Mono.just(data);
                    } else {
                        return Mono.error(new Exception("잘못된 비밀번호"));
                    }
                })
                .onErrorResume(NoSuchElementException.class, error -> Mono.error(new Exception("사용자를 찾을 수 없음")));
    }

    public Mono<Student> seeProfile(long studentId) {
        return userRepository.findByStudentId(studentId)
                .onErrorResume(NoSuchElementException.class, error -> Mono.error(new Exception("조회 실패")));
    }

    public Mono<ServerResponse> editProfile(EditProfileRequest request) {
        return userRepository.findByStudentId(request.getStudentId())
                .flatMap(data -> {
                    data.setPassword(passwordEncoder.encode(request.getPassword()));
                    data.setName(request.getName());
                    data.setEmail(request.getEmail());

                    return userRepository.save(data)
                            .flatMap(newProfile -> ServerResponse.ok().bodyValue("회원 정보 수정 성공"));
                })
                .onErrorResume(NoSuchElementException.class, error -> Mono.error(new Exception("존재하지 않는 회원 정보")));
    }
}
