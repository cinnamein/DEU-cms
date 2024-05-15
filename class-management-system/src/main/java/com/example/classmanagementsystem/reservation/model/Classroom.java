package com.example.classmanagementsystem.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "classroom")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    private Long id; // 강의실 id

    private String name; // 강의실명
}
