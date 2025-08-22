package com.example.careercenterV2.mappers;

import com.example.careercenterV2.models.requests.edit.EditOffreRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OffreMapper extends ApplicationMapper<AddOffreRequest, OffreResponse, Offre> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "company", ignore = true)
    @Mapping(target = "reference", ignore = true)
    @Mapping(target = "datePublication", ignore = true)
    Offre requestToEntity(AddOffreRequest request);


    void updateEntity(EditOffreRequest request, @MappingTarget Offre entity);


    @Override
    OffreResponse entityToResponse(Offre entity);
}
