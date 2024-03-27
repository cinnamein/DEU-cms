package com.example.classmanagementsystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    IMPOSSIBLE_RESERVATION(400, "cannot reserve seat");

    private int status;

    private String message;
}
