package com.example.classmanagementsystem.user.router;

import com.example.classmanagementsystem.user.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class UserRouter {
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.route()
                .path("/account", builder ->
                        builder
                                .POST("register", userHandler::register)
                                .POST("login", userHandler::login)
                                .GET("mypage", userHandler::seeProfile)
                                .PATCH("edit", userHandler::editProfile)
                ).build();
    }
}
