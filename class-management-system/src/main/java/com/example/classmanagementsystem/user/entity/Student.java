package com.example.classmanagementsystem.user.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("student")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long id; // 학생 id

    private String name; // 학생 이름

    private Integer studentId; // 학번

    private String email; // 이메일

    private Integer grade; // 학년
}
