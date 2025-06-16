package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ExperienceMapper extends ApplicationMapper<AddExperienceRequest, ExperienceResponse, Experience>{
    Experience requestToEntity(AddExperienceRequest request);
    void updateEntity(EditExperienceRequest request,@MappingTarget Experience entity);
    List<ExperienceResponse> listToResponseList(List<Experience> entities);
}
