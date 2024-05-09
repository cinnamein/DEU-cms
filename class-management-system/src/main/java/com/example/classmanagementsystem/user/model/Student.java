package com.example.classmanagementsystem.user.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("students")
@Getter
@Setter
public class Student {
    @Id
    private long idx;
    private long studentId;
    private String password;
    private String name;
    private String email;
    private Integer grade;
}
