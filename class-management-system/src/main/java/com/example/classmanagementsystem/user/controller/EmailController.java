package com.example.classmanagementsystem.user.controller;

import com.example.classmanagementsystem.user.service.EmailService;
import com.example.classmanagementsystem.user.service.UserService;
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
public class EmailController {
    private final EmailService emailService;
    private final UserService memberService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("email") String email) {
        memberService.sendCodeToEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
