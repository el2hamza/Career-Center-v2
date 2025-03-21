package com.example.careercenterV2.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.careercenterV2.entities.Offre;
import com.example.careercenterV2.models.requests.add.AddOffreRequest;
import com.example.careercenterV2.models.responses.OffreResponse;

@Mapper(componentModel = "spring")
public interface OffreMapper extends ApplicationMapper<AddOffreRequest, OffreResponse, Offre> {
    OffreMapper INSTANCE= Mappers.getMapper(OffreMapper.class);

}
