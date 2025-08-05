package com.example.careercenterV2.controllers;


import com.example.careercenterV2.models.requests.add.ProfileCompanyRequest;
import com.example.careercenterV2.models.responses.CompanyResponse;
import com.example.careercenterV2.models.responses.SuccessResponse;
import com.example.careercenterV2.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {
    private final CompanyService companyService;
    private MessageSource messageSource;


    @GetMapping("/all")
    public ResponseEntity<List<CompanyResponse>> get(){
        List<CompanyResponse> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> get(@PathVariable UUID id){
        CompanyResponse company = companyService.getCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<CompanyResponse> update(@RequestBody ProfileCompanyRequest request){
        CompanyResponse companyResponse = companyService.editProfileCompany(request);
        return new ResponseEntity<>(companyResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable UUID id){
        companyService.deleteCompanyById(id);
        String successMessage = messageSource.getMessage("company.controller.deleteSuccess", null, LocaleContextHolder.getLocale());
        SuccessResponse successResponse = SuccessResponse.builder()
                .message(successMessage).build() ;
        return new ResponseEntity<>(successResponse, HttpStatus.OK);

    }


}


