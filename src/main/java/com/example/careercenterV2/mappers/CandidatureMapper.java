package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Candidature;
import com.example.careercenterV2.models.requests.add.AddCandidatureRequest;
import com.example.careercenterV2.models.requests.edit.EditCandidatureRequest;
import com.example.careercenterV2.models.responses.CandidatureResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CandidatureMapper extends ApplicationMapper<AddCandidatureRequest, CandidatureResponse, Candidature> {
    Candidature requestToEntity(AddCandidatureRequest request);
    void updateEntity(EditCandidatureRequest request, @MappingTarget Candidature entity);
    List<CandidatureResponse> listToResponseList(List<Candidature> entities);
}
