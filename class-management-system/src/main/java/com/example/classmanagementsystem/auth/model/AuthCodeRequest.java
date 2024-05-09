package com.example.classmanagementsystem.auth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCodeRequest {
    private long studentId;
    private String email;
    private String userCode;
}
