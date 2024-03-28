package com.example.classmanagementsystem.service;

import com.example.classmanagementsystem.dto.CancelReservationRequestDto;
import com.example.classmanagementsystem.dto.CreateReservationRequestDto;
import com.example.classmanagementsystem.entity.Reservation;
import com.example.classmanagementsystem.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    // 예약
    private Mono<CreateReservationRequestDto> createReservation(CreateReservationRequestDto request) {

        return Mono.defer(() -> {
            if (checkValidReservation(request)) {
                return Mono.just(new CreateReservationRequestDto())
                        .doOnNext(reservation -> {
                            reservation.setReserver(1L); // TODO: 사용자 id 불러오는 기능 구현 필요
                            reservation.setClassroom(request.getClassroom());
                            reservation.setReservedStartTime(request.getReservedStartTime());
                            reservation.setReservedEndTime(request.getReservedEndTime());
                            reservation.setSeat(request.getSeat());
                        });
            } else {
                return Mono.error(new IllegalStateException("불가능한 예약입니다."));
            }
        });
    }

    // 예약 내역 확인
    public Flux<Reservation> checkReservation() {
        // TODO
        return reservationRepository.findAllByReserver(1L)
                .switchIfEmpty(Flux.error(new RuntimeException("예약 내역이 존재하지 않습니다.")));
    }

    // 예약 취소
    public Mono<Void> cancelReservation(CancelReservationRequestDto request) {
        return reservationRepository.deleteById(request.getReservationId());
    }

    public boolean checkValidReservation(CreateReservationRequestDto request) {
        // 예약 가능 여부 확인
        return !reservationRepository
                .countOverlappingReservations(request.getClassroom(),
                        request.getSeat(),
                        request.getReservedStartTime(),
                        request.getReservedEndTime());
    }

}
