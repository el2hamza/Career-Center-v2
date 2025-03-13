package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;


import java.util.List;
import java.util.Optional;

public interface OffreService {

    List<Offre> getAllOffre();

    OffreResponse addOffre(AddOffreRequest addOffreRequest) throws Exception;

    OffreResponse editOffre(EditOffreRequest offre, long id) throws Exception;

    void deleteOffre(long id) throws Exception;

    List<Offre> getOffreByType(String type) throws Exception;

    List<Offre> getOffreBySecteur(String secteur) throws Exception;

    List<Offre> getExpiredOffres() throws Exception;




}
