package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OffreRepository extends JpaRepository<Offre, Long> {


    Optional<Offre> findByReference(String reference);

    List<Offre> findAll() ;

    @Override
    Optional<Offre> findById(Long aLong);

    List<Offre> findByDateClotureBefore(Date date);

    List<Offre> findByType(String type);

    List<Offre> findBySecteur(String secteur);

}
