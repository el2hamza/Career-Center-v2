package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Candidature;
import com.example.careercenterV2.mappers.CandidatureMapper;
import com.example.careercenterV2.models.requests.add.AddCandidatureRequest;
import com.example.careercenterV2.models.requests.edit.EditCandidatureRequest;
import com.example.careercenterV2.models.responses.CandidatureResponse;
import com.example.careercenterV2.repositories.CandidatureRepository;
import com.example.careercenterV2.repositories.OffreRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.services.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {
    private final CandidatureRepository candidatureRepository;
    private final StudentRepository studentRepository;
    private final OffreRepository offreRepository;
    private final CandidatureMapper candidatureMapper;

    @Override
    public CandidatureResponse create(AddCandidatureRequest request) {
        Candidature candidature = new Candidature();
        candidature.setCandidat(studentRepository.findById(request.getCandidatId()).orElseThrow());
        candidature.setOffre(offreRepository.findById(request.getOffreId()).orElseThrow());
        candidature.setDateSoumission(request.getDateSoumission());
        candidature.setStatus("EN_COURS");
        return candidatureMapper.entityToResponse(candidatureRepository.save(candidature));
    }

    /*@Override
    public CandidatureResponse update(UUID id, EditCandidatureRequest request) {
        Candidature candidature = candidatureRepository.findById(id).orElseThrow();
        candidatureMapper.updateEntity(request, candidature);
        return candidatureMapper.entityToResponse(candidatureRepository.save(candidature));
    } */

    @Override
    public CandidatureResponse getById(UUID id) {
        return candidatureMapper.entityToResponse(candidatureRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CandidatureResponse> getAll() {
        return candidatureRepository.findAll().stream()
                .map(candidatureMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidatureResponse> getByOffre(long offreId) {
        return candidatureRepository.findByOffreId(offreId).stream()
                .map(candidatureMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidatureResponse> getByCandidat(UUID candidatId) {
        return candidatureRepository.findByCandidatId(candidatId).stream()
                .map(candidatureMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CandidatureResponse accepterCandidature(UUID id) {
        Candidature candidature = candidatureRepository.findById(id).orElseThrow();
        candidature.setStatus("ACCEPTEE");
        return candidatureMapper.entityToResponse(candidatureRepository.save(candidature));
    }

    @Override
    public CandidatureResponse rejeterCandidature(UUID id) {
        Candidature candidature = candidatureRepository.findById(id).orElseThrow();
        candidature.setStatus("REJETEE");
        return candidatureMapper.entityToResponse(candidatureRepository.save(candidature));
    }

}
