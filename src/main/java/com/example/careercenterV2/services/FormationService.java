package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;

import java.util.List;

public interface FormationService {

    List<Formation> getAllFormations();

    FormationResponse addFormation(AddFormationRequest formation) throws Exception;

    FormationResponse editFormation(EditFormationRequest formation, long id) throws Exception;

    void deleteFormation(Long id) throws Exception;
}
