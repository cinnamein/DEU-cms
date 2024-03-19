package com.example.classmanagementsystem.repository;

import com.example.classmanagementsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT COUNT(r) FROM Reservation AS r " +
            "WHERE r.classroomId = :classroomId " +
            "AND r.seat = :seat " +
            "AND (:startTime BETWEEN r.reservedStartTime AND r.reservedEndTime - 1 " +
            "OR :endTime BETWEEN r.reservedStartTime AND r.reservedEndTime - 1)")
    boolean countOverlappingReservations(@Param("classroomId") Long classroomId,
                                         @Param("seat") Integer seat,
                                         @Param("startTime") Integer startTime,
                                         @Param("endTime") Integer endTime);
}
