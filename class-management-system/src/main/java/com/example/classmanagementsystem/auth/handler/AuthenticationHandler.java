package com.example.classmanagementsystem.auth.handler;

import com.example.classmanagementsystem.auth.model.AuthCodeRequest;
import com.example.classmanagementsystem.auth.model.EmailRequest;
import com.example.classmanagementsystem.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationHandler {

    private final AuthenticationService authenticationService;

    public Mono<ServerResponse> sendEmail(ServerRequest request) {
        return request.bodyToMono(EmailRequest.class)
                .flatMap(data -> authenticationService.sendEmail(data.getStudentId(), data.getEmail())
                        .flatMap(response -> ServerResponse.ok().bodyValue("이메일 전송 성공"))
                        .onErrorResume(error -> Mono.error(new Exception("이메일 전송 실패"))));
    }

    public Mono<ServerResponse> verifyEmail(ServerRequest request) {
        return request.bodyToMono(AuthCodeRequest.class)
                .flatMap(data -> authenticationService.compareVerificationCode(data.getEmail(), data.getUserCode())
                        .flatMap(response -> ServerResponse.ok().bodyValue("인증번호 일치"))
                        .onErrorResume(error -> Mono.error(new Exception("인증번호 불일치"))));
    }
}
