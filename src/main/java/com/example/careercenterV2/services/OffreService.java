package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;


import java.util.List;
import java.util.Optional;

public interface OffreService {

    List<OffreResponse> getAllOffre();

    OffreResponse addOffre(AddOffreRequest addOffreRequest) ;

    OffreResponse editOffre(EditOffreRequest offre, long id) ;

    void deleteOffre(long id) ;

    List<OffreResponse> getOffreByType(String type) ;

    List<OffreResponse> getOffreBySecteur(String secteur) ;

    List<OffreResponse> getExpiredOffres() ;




}
