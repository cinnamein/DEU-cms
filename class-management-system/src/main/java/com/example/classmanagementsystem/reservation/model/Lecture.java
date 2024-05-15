package com.example.classmanagementsystem.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "lecture")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    @Id
    private Long id; // 강의 id

    private String lectureNum; // 강의명
}
