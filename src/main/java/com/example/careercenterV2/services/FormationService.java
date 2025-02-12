package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.models.requests.AddFormationRequest;
import com.example.careercenterV2.models.responses.AddFormationResponse;

import java.util.List;

public interface FormationService {

    List<Formation> getAllFormations();

    AddFormationResponse addFormation(AddFormationRequest formation) throws Exception;

    Formation editFormation(Formation formation) throws Exception;

    void deleteFormation(Long id) throws Exception;
}
