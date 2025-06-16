package com.example.careercenterV2.mappers;

import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface OffreMapper extends ApplicationMapper<AddOffreRequest, OffreResponse, Offre> {
    Offre requestToEntity(AddOffreRequest request);
    void updateEntity(EditOffreRequest request, @MappingTarget Offre entity);
    List<OffreResponse> listToResponseList(List<Offre> entities);
}
