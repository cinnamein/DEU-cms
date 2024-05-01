package com.example.classmanagementsystem.reservation.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("reservation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private Long id; // 예약 번호

    private Long classroomId; // 강의실 id

    private Integer seat; // 예약 좌석

    private Long reserver; // 예약자 id

    private Integer reservedStartTime; // 예약 시작 시간

    private Integer reservedEndTime; // 예약 종료 시간
}
