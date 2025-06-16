package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CandidatureRepository extends JpaRepository<Candidature, UUID> {
    List<Candidature> findByOffreId(UUID offreId);

    List<Candidature> findByCandidatId(UUID candidatId);
}
