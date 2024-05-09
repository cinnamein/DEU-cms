package com.example.classmanagementsystem.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {
    private final String to;
    private final String subject;
    private final String content;
}
