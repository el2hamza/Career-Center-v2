package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Override
    List<Experience> findAll();

    Optional<Experience> findById(long id);
}
