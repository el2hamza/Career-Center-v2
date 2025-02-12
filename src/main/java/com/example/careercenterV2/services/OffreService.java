package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.AddOffreRequest;
import com.example.careercenterV2.models.responses.AddOffreResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OffreService {

    List<Offre> getAllOffre();

    AddOffreResponse addOffre(AddOffreRequest addOffreRequest) throws Exception;

    Offre editOffre(Offre offre, long id) throws Exception;

    void deleteOffre(long id) throws Exception;

    Optional<Offre> getOffreByType(String type) throws Exception;

    Optional<Offre> getOffreBySecteur(String secteur) throws Exception;

    Optional<Offre> getOffreByDateCloture() throws Exception;



}
