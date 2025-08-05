package com.example.careercenterV2.services;


import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;

import java.util.List;
import java.util.UUID;

public interface FormationService {

    List<FormationResponse> getAllFormations();

    FormationResponse addFormation(AddFormationRequest formation) ;

    FormationResponse editFormation(EditFormationRequest formation, long id) ;

    void deleteFormation(long id) ;

    //List<FormationResponse> getFormationByStudent(UUID id) ;
}
