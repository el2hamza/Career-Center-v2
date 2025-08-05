package com.example.careercenterV2.controllers;



import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import com.example.careercenterV2.models.responses.SuccessResponse;
import com.example.careercenterV2.services.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;
    private final MessageSource messageSource;

    @PostMapping()
    public ResponseEntity<ExperienceResponse> add(@Valid @RequestBody AddExperienceRequest request){
        ExperienceResponse experience = experienceService.addExperience(request);
        return new ResponseEntity<>(experience, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ExperienceResponse>> get(){
        List<ExperienceResponse> experiences = experienceService.getAllExperience();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    //@GetMapping
    //public ResponseEntity<ExperienceResponse> get(){}

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> update(@RequestBody EditExperienceRequest request, @PathVariable long id){
        ExperienceResponse experience = experienceService.editExperience(request, id);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable long id){
        experienceService.deleteExperience(id);
        String successMessage = messageSource.getMessage("experience.controller.deleteSuccess",null, LocaleContextHolder.getLocale());
        SuccessResponse successResponse = SuccessResponse.builder()
                .message(successMessage).build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

}
