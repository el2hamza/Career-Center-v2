package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.exceptions.ResourceNotFound;
import com.example.careercenterV2.mappers.ExperienceMapper;
import com.example.careercenterV2.mappers.FormationMapper;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import com.example.careercenterV2.repositories.ExperienceRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final StudentRepository studentRepository;
    private final ExperienceMapper experienceMapper;
    private final MessageSource messageSource;

    @Override
    public ExperienceResponse addExperience(AddExperienceRequest experienceRequest)  {

        UUID studentId = experienceRequest.getStudentId();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFound(messageSource.getMessage("Student.not.found",null, Locale.getDefault()))) ;
        Experience experience = experienceMapper.requestToEntity(experienceRequest);
        return experienceMapper.entityToResponse(experienceRepository.save(experience));
    }

    @Override
    public ExperienceResponse editExperience(EditExperienceRequest experienceRequest, long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(messageSource.getMessage("Experience.not.found",null, Locale.getDefault()))) ;
        experienceMapper.updateEntity(experienceRequest, experience);
        return experienceMapper.entityToResponse(experienceRepository.save(experience));
    }

    @Override
    public void deleteExperience(long id) {

        Experience experience= experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(messageSource.getMessage("Experience.not.found",null, Locale.getDefault())));

        experienceRepository.delete(experience);
    }

    @Override
    public List<ExperienceResponse> getAllExperience(){
        List<Experience> experiences = experienceRepository.findAll();
        return experienceMapper.listToResponseList(experiences);
    }


}
