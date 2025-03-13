package com.example.careercenterV2.repositories;

import com.example.careercenterV2.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findById(UUID id);

}
