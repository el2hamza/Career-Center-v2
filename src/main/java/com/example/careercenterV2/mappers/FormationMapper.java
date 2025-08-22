package com.example.careercenterV2.mappers;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FormationMapper extends ApplicationMapper<AddFormationRequest, FormationResponse, Formation>{

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "student", ignore = true)
    Formation requestToEntity(AddFormationRequest request);

    void updateEntity(EditFormationRequest request,@MappingTarget Formation entity);


}
