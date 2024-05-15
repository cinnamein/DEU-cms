package com.example.classmanagementsystem.reservation.repository;

import com.example.classmanagementsystem.reservation.model.Reservation;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {
    @Query("SELECT COUNT(r) FROM Reservation AS r " +
            "WHERE r.classroomId = :classroomId " +
            "AND r.seat = :seat " +
            "AND (:startTime BETWEEN r.reservedStartTime AND r.reservedEndTime - 1 " +
            "OR :endTime BETWEEN r.reservedStartTime AND r.reservedEndTime - 1)")
    boolean countOverlappingReservations(@Param("classroomId") Long classroomId,
                                         @Param("seat") Integer seat,
                                         @Param("startTime") Integer startTime,
                                         @Param("endTime") Integer endTime);


    Flux<Reservation> findAllByReserver(Long reserver);
}
