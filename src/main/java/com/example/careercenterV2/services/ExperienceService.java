package com.example.careercenterV2.services;

import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.models.requests.AddExperienceRequest;
import com.example.careercenterV2.models.responses.AddExperienceResponse;

import java.util.List;

public interface ExperienceService {

    List<Experience> getAllExperience();

    AddExperienceResponse addExperience (AddExperienceRequest experience) throws Exception;

    Experience editExperience (Experience experience, long id) throws Exception;

    void deleteExperience (long id) throws Exception;
}
