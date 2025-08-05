package com.example.careercenterV2.controllers;

import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import com.example.careercenterV2.models.responses.SuccessResponse;
import com.example.careercenterV2.services.FormationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
@RequiredArgsConstructor
public class FormationController {
    private final FormationService formationService;
    private final MessageSource messageSource;


    @PostMapping()
    public ResponseEntity<FormationResponse> add(@Valid @RequestBody AddFormationRequest request){
        FormationResponse response = formationService.addFormation(request);
        //String successMessage = messageSource.getMessage( "formation.controller.addSuccess",null, LocaleContextHolder.getLocale());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FormationResponse>> get(){
        List<FormationResponse> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    //@GetMapping("/{id}")
    // public ResponseEntity<FormationResponse> get(@PathVariable long id){}

    @PutMapping("/{id}")
    public ResponseEntity<FormationResponse> update(@RequestBody EditFormationRequest request, @PathVariable long id){
        FormationResponse formation = formationService.editFormation(request, id);
        return new ResponseEntity<>(formation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable long id){
        formationService.deleteFormation(id);
        String successMessage = messageSource.getMessage("formation.controller.deleteSuccess", null, LocaleContextHolder.getLocale());
        SuccessResponse successResponse = SuccessResponse.builder()
                .message(successMessage).build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }


}
