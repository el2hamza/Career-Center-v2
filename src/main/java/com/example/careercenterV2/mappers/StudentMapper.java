package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.models.responses.StudentResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends ApplicationMapper<RegisterStudentRequest, StudentResponse, Student>{

    @Override
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "phone", source = "phone")
    })
    Student requestToEntity(RegisterStudentRequest request);

    @Override
    StudentResponse entityToResponse(Student student);

    // Met à jour les infos du profil à partir de ProfileStudentRequest
    void updateProfileFromRequest(ProfileStudentRequest request, @MappingTarget Student student);
}
