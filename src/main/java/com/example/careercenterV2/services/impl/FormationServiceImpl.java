package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import com.example.careercenterV2.repositories.FormationRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.FormationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final StudentRepository studentRepository;

    public FormationServiceImpl(FormationRepository formationRepository, StudentRepository studentRepository) {
        this.formationRepository = formationRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public FormationResponse addFormation(AddFormationRequest formationRequest) throws Exception {
        //check if formation exist by diplome obtenue
        Optional<Formation> formationOptional= formationRepository.findByDiplomeObtenue(formationRequest.getDiplomeObtenue());
        if(formationOptional.isPresent())
            throw new Exception("Formation already exists") ;

        UUID studentId = formationRequest.getStudentId();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("Student not found")) ;

        Formation build = Formation.builder()
                .description(formationRequest.getDescription())
                .speciality(formationRequest.getSpeciality())
                .diplomeObtenue(formationRequest.getDiplomeObtenue())
                .ecole(formationRequest.getEcole())
                .niveau(formationRequest.getNiveau())
                .city(formationRequest.getCity())
                .state(formationRequest.getState())
                .dateDebut(formationRequest.getDateDebut())
                .dateFin(formationRequest.getDateFin())
                .diplomeUrl(formationRequest.getDiplomeUrl())
                .student(student)
                .build();

        Formation saved = formationRepository.save(build);

        return FormationResponse.builder()
                .id(saved.getId())
                .diplomeObtenue(saved.getDiplomeObtenue())
                .dateDebut(saved.getDateDebut())
                .dateFin(saved.getDateFin())
                .build() ;


    }


    @Override
    public FormationResponse editFormation(EditFormationRequest formationRequest, long id) throws Exception{

        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new Exception("Formation not found")) ;

        if(formationRequest.getDiplomeObtenue() != null)
            formation.setDiplomeObtenue(formationRequest.getDiplomeObtenue());

        if(formationRequest.getEcole() != null)
            formation.setEcole(formationRequest.getEcole());

        if(formationRequest.getDescription() != null)
            formation.setDescription(formationRequest.getDescription());

        if(formationRequest.getNiveau() != null)
            formation.setNiveau(formationRequest.getNiveau());

        if(formationRequest.getDateDebut() != null)
            formation.setDateDebut(formationRequest.getDateDebut());

        if(formationRequest.getDateFin() != null)
            formation.setDateFin(formationRequest.getDateFin());

        if(formationRequest.getSpeciality() != null)
            formation.setSpeciality(formationRequest.getSpeciality());

        if(formationRequest.getDiplomeUrl() != null)
            formation.setDiplomeUrl(formationRequest.getDiplomeUrl());

        if(formationRequest.getState() != null)
            formation.setState(formationRequest.getState());

        if(formationRequest.getCity() != null)
            formation.setCity(formationRequest.getCity());

        Formation updated = formationRepository.save(formation);

        return FormationResponse.builder()
                .id(updated.getId())
                .description(updated.getDescription())
                .ecole(updated.getEcole())
                .diplomeObtenue(updated.getDiplomeObtenue())
                .niveau(updated.getNiveau())
                .speciality(updated.getSpeciality())
                .diplomeUrl(updated.getDiplomeUrl())
                .city(updated.getCity())
                .dateFin(updated.getDateFin())
                .dateDebut(updated.getDateDebut())
                .build() ;
    }

    @Override
    public void deleteFormation(Long id) throws Exception{
        Formation formation = formationRepository.findById(id)
                .orElseThrow(() -> new Exception("Formation not found")) ;
        formationRepository.delete(formation);
    }

    @Override
    public List<Formation> getAllFormations(){
        return formationRepository.findAll();
    }



}
