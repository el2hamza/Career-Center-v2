package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Experience;
import com.example.careercenterV2.models.requests.add.AddExperienceRequest;
import com.example.careercenterV2.models.requests.edit.EditExperienceRequest;
import com.example.careercenterV2.models.responses.ExperienceResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienceMapper extends ApplicationMapper<AddExperienceRequest, ExperienceResponse, Experience>{

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    Experience requestToEntity(AddExperienceRequest request);

    void updateEntity(EditExperienceRequest request,@MappingTarget Experience entity);


    @Override
    @Mapping(target = "studentId", source = "student.id")
    ExperienceResponse entityToResponse(Experience entity);
}
