package com.example.classmanagementsystem.user.handler;

import com.example.classmanagementsystem.user.model.EditProfileRequest;
import com.example.classmanagementsystem.user.model.LoginRequest;
import com.example.classmanagementsystem.user.model.Student;
import com.example.classmanagementsystem.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;

    public Mono<ServerResponse> register(ServerRequest request) {
        return request.bodyToMono(Student.class)
                .flatMap(data -> userService.register(request)
                        .flatMap(response -> ServerResponse.ok().bodyValue("가입 성공"))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue("가입 실패")));
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(LoginRequest.class)
                .flatMap(data -> userService.login(data.getStudentId(), data.getPassword())
                        .flatMap(response -> ServerResponse.ok().bodyValue("로그인 성공"))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.UNAUTHORIZED).bodyValue("로그인 실패")));
    }

    public Mono<ServerResponse> seeProfile(ServerRequest request) {
        return request.bodyToMono(Student.class)
                .flatMap(data -> userService.seeProfile(data.getStudentId())
                        .flatMap(response -> ServerResponse.ok().bodyValue("계정 조회 성공"))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.UNAUTHORIZED).bodyValue("계정 조회 실패")));
    }

    public Mono<ServerResponse> editProfile(ServerRequest request) {
        return request.bodyToMono(EditProfileRequest.class)
                .flatMap(data -> userService.editProfile(data)
                        .flatMap(response -> ServerResponse.ok().bodyValue("계정 정보 수정 성공"))
                        .onErrorResume(error -> ServerResponse.status(HttpStatus.UNAUTHORIZED).bodyValue("계정 정보 수정 실패")));
    }
}
