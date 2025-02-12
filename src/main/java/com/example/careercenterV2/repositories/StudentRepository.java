package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Override
    List<Student> findAll();

    @Override
    Optional<Student> findById(UUID uuid);


}
