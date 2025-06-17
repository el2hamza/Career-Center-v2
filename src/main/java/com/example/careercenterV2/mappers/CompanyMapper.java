package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.RegisterCompanyRequest;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.requests.add.ProfileCompanyRequest;
import com.example.careercenterV2.models.requests.add.ProfileStudentRequest;
import com.example.careercenterV2.models.responses.CompanyResponse;
import com.example.careercenterV2.models.responses.StudentResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompanyMapper extends ApplicationMapper<RegisterCompanyRequest, CompanyResponse, Company> {

    @Override
    Company requestToEntity(RegisterCompanyRequest request);

    @Override
    CompanyResponse entityToResponse(Company company);

    @Override
    List<CompanyResponse> listToResponseList(List<Company> companies);

    // Met à jour les infos du profil à partir de ProfileCompanyRequest
    void updateProfileFromRequest(ProfileCompanyRequest request, @MappingTarget Company company);
}
