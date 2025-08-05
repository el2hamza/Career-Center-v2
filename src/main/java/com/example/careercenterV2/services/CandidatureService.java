package com.example.careercenterV2.services;


import com.example.careercenterV2.models.requests.add.AddCandidatureRequest;
import com.example.careercenterV2.models.responses.CandidatureResponse;

import java.util.List;
import java.util.UUID;

public interface CandidatureService {

    CandidatureResponse create(AddCandidatureRequest request);

    //CandidatureResponse update(UUID id, EditCandidatureRequest request);

    CandidatureResponse getById(UUID id);

    List<CandidatureResponse> getAll();

    List<CandidatureResponse> getByOffre(long offreId);

    List<CandidatureResponse> getByCandidat(UUID candidatId);

    CandidatureResponse accepterCandidature(UUID id);

    CandidatureResponse rejeterCandidature(UUID id);
}
