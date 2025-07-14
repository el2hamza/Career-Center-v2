package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationRepository extends JpaRepository<Formation, Long> {


    Optional<Formation> findByDiplomeObtenue(String diplomeObtenue);

    Optional<Formation> findById(long id);

    Optional<Formation> getFormationsByStudent(Student student);
}

