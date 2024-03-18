package com.example.classmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLectureRequestDto {
    private Long lectureNum; // 강의 id

    private Integer lectureStartTime; // 강의 시작 시간

    private Integer lectureEndTime; // 강의 종료 시간

    private Long classroomId; // 강의실 id
}
