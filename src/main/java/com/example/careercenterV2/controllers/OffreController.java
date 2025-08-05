package com.example.careercenterV2.controllers;


import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;
import com.example.careercenterV2.models.responses.SuccessResponse;
import com.example.careercenterV2.services.OffreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/offre")
@RequiredArgsConstructor
public class OffreController {

    private final OffreService offreService;
    private final MessageSource messageSource;

    @PostMapping()
    public ResponseEntity<OffreResponse> add(@Valid @RequestBody AddOffreRequest request){
        OffreResponse offre = offreService.addOffre(request) ;
        return new ResponseEntity<>(offre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OffreResponse> update(@RequestBody EditOffreRequest request,@PathVariable long id){
        OffreResponse offre = offreService.editOffre(request,id) ;
        return new ResponseEntity<>(offre, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OffreResponse>> get(){
        List<OffreResponse> offres = offreService.getAllOffre();
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<OffreResponse>> getByType(@PathVariable String type){
        List<OffreResponse> offres = offreService.getOffreByType(type);
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/{secteur}")
    public ResponseEntity<List<OffreResponse>> getBySecteur(@PathVariable String secteur){
        List<OffreResponse> offres = offreService.getOffreBySecteur(secteur);
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<OffreResponse>> getExpired(){
        List<OffreResponse> offres = offreService.getExpiredOffres();
        return new ResponseEntity<>(offres, HttpStatus.OK);
    }

    //@GetMapping
    //public ResponseEntity<OffreResponse> get(){}

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable long id){
        offreService.deleteOffre(id);
        String successMessage = messageSource.getMessage("offre.controller.deleteSuccess",null, LocaleContextHolder.getLocale());
        SuccessResponse successResponse = SuccessResponse.builder()
                .message(successMessage).build();
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
