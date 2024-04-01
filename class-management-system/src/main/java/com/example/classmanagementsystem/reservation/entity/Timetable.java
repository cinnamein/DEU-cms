package com.example.classmanagementsystem.reservation.entity;

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
@Table(name="timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 시간표 id

    private String lectureId; // 강의 id

    private Integer lectureStartTime; // 강의 시작 시간

    private Integer lectureEndTime; // 강의 종료 시간

    private Long classroomId; // 강의실 id
}
