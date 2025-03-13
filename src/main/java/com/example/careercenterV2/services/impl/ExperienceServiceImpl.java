package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import com.example.careercenterV2.repositories.ExperienceRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final StudentRepository studentRepository;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository, StudentRepository studentRepository) {
        this.experienceRepository = experienceRepository;
        this.studentRepository = studentRepository;

    }

    @Override
    public ExperienceResponse addExperience(AddExperienceRequest experienceRequest) throws Exception {

        UUID studentId = experienceRequest.getStudentId();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found")) ;

        Experience build = Experience.builder()
                .poste(experienceRequest.getPoste())
                .type(experienceRequest.getType())
                .city(experienceRequest.getCity())
                .description(experienceRequest.getDescription())
                .nomEntreprise(experienceRequest.getNomEntreprise())
                .state(experienceRequest.getState())
                .dateDebut(experienceRequest.getDateDebut())
                .dateFin(experienceRequest.getDateFin())
                .student(student)
                .build() ;

        Experience saved = experienceRepository.save(build);

        return ExperienceResponse.builder()
                .id(saved.getId())
                .poste(saved.getPoste())
                .nomEntreprise(saved.getNomEntreprise())
                .dateDebut(saved.getDateDebut())
                .build() ;

    }

    @Override
    public ExperienceResponse editExperience(EditExperienceRequest experienceRequest, long id) throws Exception{
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new Exception("Experience not found")) ;

        if(experienceRequest.getPoste() != null)
            experience.setPoste(experienceRequest.getPoste());

        if(experienceRequest.getType() != null)
            experience.setType(experienceRequest.getType());

        if(experienceRequest.getCity() != null)
            experience.setCity(experienceRequest.getCity());

        if(experienceRequest.getDescription() != null)
            experience.setDescription(experienceRequest.getDescription());

        if(experienceRequest.getNomEntreprise() != null)
            experience.setNomEntreprise(experienceRequest.getNomEntreprise());

        if(experienceRequest.getState() != null)
            experience.setState(experienceRequest.getState());

        if(experienceRequest.getDateDebut() != null)
            experience.setDateDebut(experienceRequest.getDateDebut());

        if(experienceRequest.getDateFin() != null)
            experience.setDateFin(experienceRequest.getDateFin());

        Experience updated = experienceRepository.save(experience);

        return ExperienceResponse.builder()
                .id(updated.getId())
                .poste(updated.getPoste())
                .nomEntreprise(updated.getNomEntreprise())
                .dateDebut(updated.getDateDebut())
                .dateFin(updated.getDateFin())
                .build() ;


    }

    @Override
    public void deleteExperience(long id) throws Exception{

        Experience experience= experienceRepository.findById(id)
                .orElseThrow(() -> new Exception("Experience not found"));

        experienceRepository.delete(experience);
    }

    @Override
    public List<Experience> getAllExperience(){
        return experienceRepository.findAll();
    }


}
