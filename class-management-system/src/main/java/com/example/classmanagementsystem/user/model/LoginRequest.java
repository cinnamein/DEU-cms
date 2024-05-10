package com.example.classmanagementsystem.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private long studentId;
    private String password;
}
