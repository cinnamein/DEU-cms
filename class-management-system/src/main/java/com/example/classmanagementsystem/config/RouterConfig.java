package com.example.classmanagementsystem.config;

import com.example.classmanagementsystem.auth.handler.AuthenticationHandler;
import com.example.classmanagementsystem.user.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@EnableWebFlux
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> helloRouter() {
        return RouterFunctions.route()
                .GET("/hello", request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue("main page body"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.route()
                .path("/account", builder ->
                        builder
                                .POST("/register", userHandler::register)
                                .POST("/login", userHandler::login)
                                .GET("/mypage", userHandler::seeProfile)
                                .PATCH("/edit", userHandler::editProfile)
                ).build();
    }

    @Bean
    public RouterFunction<ServerResponse> authenticationRouter(AuthenticationHandler authenticationHandler) {
        return RouterFunctions.route()
                .path("/authentication", builder ->
                        builder
                                .POST("/", authenticationHandler::sendEmail)
                                .GET("/authcode", authenticationHandler::verifyEmail)
                ).build();
    }
}
