package com.example.classmanagementsystem.reservation.service;

import com.example.classmanagementsystem.reservation.model.CancelReservationRequestDto;
import com.example.classmanagementsystem.reservation.model.CreateReservationRequestDto;
import com.example.classmanagementsystem.reservation.model.Reservation;
import com.example.classmanagementsystem.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    /**
     * 예약 내역 확인
     *
     * @return
     */
    public Flux<Reservation> checkReservation() {
        // TODO
        return reservationRepository.findAllByReserver(1L)
                .switchIfEmpty(Flux.error(new RuntimeException("예약 내역이 존재하지 않습니다.")));
    }

    /**
     * 예약 메서드
     *
     * @param request
     * @return
     */
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

    /**
     * 예약 취소
     *
     * @param request
     * @return
     */
    public Mono<Void> cancelReservation(CancelReservationRequestDto request) {
        return reservationRepository.deleteById(request.getReservationId());
    }

    /**
     * 예약 가능 여부 확인
     *
     * @param request
     * @return
     */
    private boolean checkValidReservation(CreateReservationRequestDto request) {
        // 예약 가능 여부 확인
        return !reservationRepository
                .countOverlappingReservations(request.getClassroom(),
                        request.getSeat(),
                        request.getReservedStartTime(),
                        request.getReservedEndTime());
    }

}
