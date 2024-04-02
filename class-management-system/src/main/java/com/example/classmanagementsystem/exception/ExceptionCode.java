package com.example.classmanagementsystem.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public record ExceptionCode (Long status,
                             String message)
