package com.example.classmanagementsystem.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditProfileRequest {
    private long studentId;
    private String password;
    private String name;
    private String email;
}
