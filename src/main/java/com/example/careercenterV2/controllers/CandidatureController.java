package com.example.careercenterV2.controllers;

import com.example.careercenterV2.models.requests.add.AddCandidatureRequest;
import com.example.careercenterV2.models.responses.CandidatureResponse;
import com.example.careercenterV2.services.CandidatureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/candidature")
@RequiredArgsConstructor
public class CandidatureController {

    private final CandidatureService candidatureService;

    @PostMapping()
    public ResponseEntity<CandidatureResponse> add (@Valid @RequestBody AddCandidatureRequest request) {
        CandidatureResponse candidature = candidatureService.create(request);
        return new ResponseEntity<>(candidature, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidatureResponse>> get(){
        List<CandidatureResponse> candidatures = candidatureService.getAll();
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatureResponse> get(@PathVariable UUID id){
        CandidatureResponse candidature = candidatureService.getById(id);
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CandidatureResponse>> getMine(@PathVariable UUID id){
        List<CandidatureResponse> candidatures = candidatureService.getByCandidat(id) ;
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CandidatureResponse>> getByOffre(@PathVariable long id){
        List<CandidatureResponse> candidatures = candidatureService.getByOffre(id);
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatureResponse> accept(@PathVariable UUID id){
        CandidatureResponse candidature = candidatureService.accepterCandidature(id) ;
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidatureResponse> reject(@PathVariable UUID id){
        CandidatureResponse candidature = candidatureService.rejeterCandidature(id) ;
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }


}
