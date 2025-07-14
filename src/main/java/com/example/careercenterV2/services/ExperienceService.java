package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;

import java.util.List;

public interface ExperienceService {


    List<ExperienceResponse> getAllExperience();

    ExperienceResponse addExperience (AddExperienceRequest experience) ;

    void deleteExperience (long id) ;

    ExperienceResponse editExperience(EditExperienceRequest experienceRequest, long id) ;
}
