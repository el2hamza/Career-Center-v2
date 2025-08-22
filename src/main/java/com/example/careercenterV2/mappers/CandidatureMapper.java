package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Candidature;
import com.example.careercenterV2.models.requests.add.AddCandidatureRequest;
import com.example.careercenterV2.models.requests.edit.EditCandidatureRequest;
import com.example.careercenterV2.models.responses.CandidatureResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidatureMapper extends ApplicationMapper<AddCandidatureRequest, CandidatureResponse, Candidature> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "candidat", ignore = true)
    @Mapping(target = "offre", ignore = true)
    Candidature requestToEntity(AddCandidatureRequest request);

    void updateEntity(EditCandidatureRequest request, @MappingTarget Candidature entity);

    @Override
    @Mapping(target = "candidatId", source = "candidat.id")
    @Mapping(target = "offreId", source = "offre.id")
    CandidatureResponse entityToResponse(Candidature entity);
}
