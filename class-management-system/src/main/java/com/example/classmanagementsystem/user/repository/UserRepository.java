package com.example.classmanagementsystem.user.repository;

import com.example.classmanagementsystem.user.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Student, Long> {
    Mono<Student> findByEmail(String email);
}
