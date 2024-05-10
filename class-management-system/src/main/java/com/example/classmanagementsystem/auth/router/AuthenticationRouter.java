package com.example.classmanagementsystem.auth.router;

import com.example.classmanagementsystem.auth.handler.AuthenticationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class AuthenticationRouter {
    public RouterFunction<ServerResponse> authenticationRouter(AuthenticationHandler authenticationHandler) {
        return RouterFunctions.route()
                .path("/authentication", builder ->
                        builder
                                .POST("/", authenticationHandler::sendEmail)
                                .GET("/authcode", authenticationHandler::verifyEmail)
                ).build();
    }
}
