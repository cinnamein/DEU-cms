package com.example.classmanagementsystem.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLectureResponseDto {
    private Long TimetableId; // 시간표 id
}
