package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.mappers.FormationMapper;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import com.example.careercenterV2.repositories.FormationRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final StudentRepository studentRepository;
    private final FormationMapper formationMapper;


    @Override
    public FormationResponse addFormation(AddFormationRequest formationRequest) throws Exception {
        //check if formation exist by diplome obtenue
        Optional<Formation> formationOptional= formationRepository.findByDiplomeObtenue(formationRequest.getDiplomeObtenue());
        if(formationOptional.isPresent())
            throw new Exception("Formation already exists") ;
        Formation formation = formationMapper.requestToEntity(formationRequest);
        return formationMapper.entityToResponse(formationRepository.save(formation));

    }


    @Override
    public FormationResponse editFormation(EditFormationRequest request, long id) throws Exception {
        Formation formation = formationRepository.findById(id).orElseThrow();
        formationMapper.updateEntity(request,formation);
        return formationMapper.entityToResponse(formationRepository.save(formation));
    }

    @Override
    public void deleteFormation(Long id) throws Exception{
        if(!formationRepository.existsById(id))
            throw new Exception("Formation does not exist");
        formationRepository.deleteById(id);
    }

    @Override
    public List<FormationResponse> getAllFormations(){
        List<Formation> formations = formationRepository.findAll();
        return formationMapper.listToResponseList(formations);
    }



}
