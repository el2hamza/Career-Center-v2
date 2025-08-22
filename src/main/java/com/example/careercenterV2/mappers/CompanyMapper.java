package com.example.careercenterV2.mappers;


import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.models.requests.RegisterCompanyRequest;
import com.example.careercenterV2.models.requests.add.ProfileCompanyRequest;
import com.example.careercenterV2.models.responses.CompanyResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper extends ApplicationMapper<RegisterCompanyRequest, CompanyResponse, Company> {

    @Override
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "name", source = "companyName"),
            @Mapping(target = "email", source = "email"),
    })
    Company requestToEntity(RegisterCompanyRequest request);

    @Override
    CompanyResponse entityToResponse(Company company);


    // Met à jour les infos du profil à partir de ProfileCompanyRequest
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({

            // @Mapping(target = "address", source = "address"),
            // @Mapping(target = "phone",   source = "phone"),
            // @Mapping(target = "city",    source = "city"),
            // @Mapping(target = "secteur", source = "secteur"),
            // @Mapping(target = "numPattente", source = "numPattente"),
            // @Mapping(target = "description", source = "description"),
            // @Mapping(target = "creationDate", source = "creationDate")
    })
    void updateProfileFromRequest(ProfileCompanyRequest request, @MappingTarget Company company);


}
