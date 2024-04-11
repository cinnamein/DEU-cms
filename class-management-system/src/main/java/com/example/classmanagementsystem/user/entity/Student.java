package com.example.classmanagementsystem.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 학생 id

    private String name; // 학생 이름

    private Integer studentId; // 학번

    private String email; // 이메일

    private Integer grade; // 학년
}
