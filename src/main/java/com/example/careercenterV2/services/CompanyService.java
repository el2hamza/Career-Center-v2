package com.example.careercenterV2.services;


import com.example.careercenterV2.models.requests.add.ProfileCompanyRequest;
import com.example.careercenterV2.models.responses.CompanyResponse;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    List<CompanyResponse> getAllCompanies();

    CompanyResponse getCompanyById(UUID id);

    CompanyResponse editProfileCompany(ProfileCompanyRequest profile) ;

    void deleteCompanyById(UUID id);



}
