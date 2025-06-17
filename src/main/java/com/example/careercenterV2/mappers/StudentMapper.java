package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.models.responses.StudentResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface StudentMapper extends ApplicationMapper<RegisterStudentRequest, StudentResponse, Student>{

    @Override
    Student requestToEntity(RegisterStudentRequest request);

    @Override
    StudentResponse entityToResponse(Student student);

    @Override
    List<StudentResponse> listToResponseList(List<Student> students);

    // Met à jour les infos du profil à partir de ProfileStudentRequest
    void updateProfileFromRequest(ProfileStudentRequest request, @MappingTarget Student student);
}
