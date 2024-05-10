package com.example.classmanagementsystem.user.repository;

import com.example.classmanagementsystem.user.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Student, Long> {

    Mono<Student> findByStudentId(long studentId);

    Mono<Boolean> existsByStudentId(long studentId);
}
