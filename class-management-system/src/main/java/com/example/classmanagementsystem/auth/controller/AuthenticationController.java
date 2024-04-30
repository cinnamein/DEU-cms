package com.example.classmanagementsystem.auth.controller;

import com.example.classmanagementsystem.auth.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("email") String receiver) {
        authenticationService.sendEmail(receiver);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/register/verification")
    public ResponseEntity verifyEmail(@RequestParam("email") String receiver, @RequestParam("code") String userCode) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
