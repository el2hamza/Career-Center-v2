package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OffreRepository extends JpaRepository<Offre, Long> {

    List<Offre> findAllByOrderByIdDesc();

    List<Offre> findAll() ;

    @Override
    Optional<Offre> findById(Long aLong);

}
