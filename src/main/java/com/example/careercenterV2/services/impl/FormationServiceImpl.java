package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.exceptions.ResourceAlreadyExistsException;
import com.example.careercenterV2.exceptions.ResourceNotFound;
import com.example.careercenterV2.mappers.FormationMapper;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import com.example.careercenterV2.repositories.FormationRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final StudentRepository studentRepository;
    private final FormationMapper formationMapper;
    private final MessageSource messageSource;


    @Override
    public FormationResponse addFormation(AddFormationRequest formationRequest) {
        //check if formation exist by diplome obtenue
        Optional<Formation> formationOptional= formationRepository.findByDiplomeObtenue(formationRequest.getDiplomeObtenue());
        if(formationOptional.isPresent()) {
            String errorMessage = messageSource.getMessage("Formation.diplome.AlreadyExists", null, LocaleContextHolder.getLocale());
            throw new ResourceAlreadyExistsException(errorMessage);
        }
        Formation formation = formationMapper.requestToEntity(formationRequest);
        return formationMapper.entityToResponse(formationRepository.save(formation));

    }


    @Override
    public FormationResponse editFormation(EditFormationRequest request, long id) {
        Formation formation = formationRepository.findById(id).orElseThrow(()->new ResourceNotFound(messageSource.getMessage("Formation.not.found",null, Locale.getDefault())));
        formationMapper.updateEntity(request,formation);
        return formationMapper.entityToResponse(formationRepository.save(formation));
    }

    @Override
    public void deleteFormation(Long id) {
        if(!formationRepository.existsById(id))
            throw new ResourceNotFound(messageSource.getMessage("Formation.not.found",null, Locale.getDefault()));
        formationRepository.deleteById(id);
    }

    @Override
    public List<FormationResponse> getAllFormations(){
        List<Formation> formations = formationRepository.findAll();
        return formationMapper.listToResponseList(formations);
    }




}
