package com.example.classmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequestDto {
    private Long reserver; // 예약자 id

    private Integer reservedStartTime; // 예약 시작 시간

    private Integer reservedEndTime; // 예약 종료 시간

    private Long classroom; // 예약한 강의실

    private Integer seat; // 예약한 좌석
}
