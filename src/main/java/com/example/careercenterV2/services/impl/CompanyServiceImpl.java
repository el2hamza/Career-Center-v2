package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.exceptions.ResourceNotFound;
import com.example.careercenterV2.mappers.CompanyMapper;
import com.example.careercenterV2.models.requests.add.ProfileCompanyRequest;
import com.example.careercenterV2.models.responses.CompanyResponse;
import com.example.careercenterV2.repositories.CompanyRepository;
import com.example.careercenterV2.services.CompanyService;
import com.example.careercenterV2.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final MessageSource messageSource;
    private final FileStorageService fileStorageService;

    @Value("${company.upload-dir}")
    private String baseUploadDir;

    @Override
    public List<CompanyResponse> getAllCompanies(){
        return companyRepository.findAll()
                .stream()
                .map(companyMapper::entityToResponse)
                .collect(Collectors.toList()) ;
    }

    @Override
    public CompanyResponse getCompanyById(UUID id ) {
        Company company = companyRepository.findById(id)
                .orElseThrow(()->new ResourceNotFound(messageSource.getMessage("Company.not.found",null, Locale.getDefault()))) ;
        return companyMapper.entityToResponse(company);
    }

    @Override
    public CompanyResponse editProfileCompany(ProfileCompanyRequest profile){
        Company company = companyRepository.findById(profile.getId())
                .orElseThrow(()-> new ResourceNotFound(messageSource.getMessage("Company.not.found",null, Locale.getDefault())) ) ;
        String uploadDir = baseUploadDir + "/" + company.getId();
        fileStorageService.createDirectoryIfNotExist(uploadDir);

        if(profile.getLogo() != null && !profile.getLogo().isEmpty()){
            String logoPath = fileStorageService.saveFile(uploadDir,"logo.jpg", profile.getLogo());
            company.setLogo(logoPath);
        }
        // Update other fields using the mapper
        companyMapper.updateProfileFromRequest(profile, company);
        companyRepository.save(company);

        return companyMapper.entityToResponse(company);

    }

    @Override
    public void deleteCompanyById(UUID id) {
        if(!companyRepository.existsById(id)){
            throw new ResourceNotFound(messageSource.getMessage("Company.not.found",null, Locale.getDefault()));
        }
        companyRepository.deleteById(id);
    }
}
