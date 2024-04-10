package com.example.classmanagementsystem.user.repository;

import com.example.classmanagementsystem.user.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
