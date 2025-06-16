package com.example.careercenterV2.mappers;

import com.example.careercenterV2.entities.Formation;
import com.example.careercenterV2.models.requests.add.AddFormationRequest;
import com.example.careercenterV2.models.requests.edit.EditFormationRequest;
import com.example.careercenterV2.models.responses.FormationResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface FormationMapper extends ApplicationMapper<AddFormationRequest, FormationResponse, Formation>{
    Formation requestToEntity(AddFormationRequest request);
    void updateEntity(EditFormationRequest request,@MappingTarget Formation entity);
    List<FormationResponse> listToResponseList(List<Formation> entities);
}
