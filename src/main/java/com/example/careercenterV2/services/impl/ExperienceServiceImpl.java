package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.mappers.ExperienceMapper;
import com.example.careercenterV2.mappers.FormationMapper;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import com.example.careercenterV2.repositories.ExperienceRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final StudentRepository studentRepository;
    private final ExperienceMapper experienceMapper;
    private final FormationMapper formationMapper;

    @Override
    public ExperienceResponse addExperience(AddExperienceRequest experienceRequest) throws Exception {

        UUID studentId = experienceRequest.getStudentId();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found")) ;
        Experience experience = experienceMapper.requestToEntity(experienceRequest);
        return experienceMapper.entityToResponse(experienceRepository.save(experience));
    }

    @Override
    public ExperienceResponse editExperience(EditExperienceRequest experienceRequest, long id) throws Exception{
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new Exception("Experience not found")) ;
        experienceMapper.updateEntity(experienceRequest, experience);
        return experienceMapper.entityToResponse(experienceRepository.save(experience));
    }

    @Override
    public void deleteExperience(long id) throws Exception{

        Experience experience= experienceRepository.findById(id)
                .orElseThrow(() -> new Exception("Experience not found"));

        experienceRepository.delete(experience);
    }

    @Override
    public List<ExperienceResponse> getAllExperience(){
        List<Experience> experiences = experienceRepository.findAll();
        return experienceMapper.listToResponseList(experiences);
    }


}
