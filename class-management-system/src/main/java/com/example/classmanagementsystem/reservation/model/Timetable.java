package com.example.classmanagementsystem.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "timetable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Timetable {
    @Id
    private Long id; // 시간표 id

    private String lectureId; // 강의 id

    private Integer lectureStartTime; // 강의 시작 시간

    private Integer lectureEndTime; // 강의 종료 시간

    private Long classroomId; // 강의실 id
}
