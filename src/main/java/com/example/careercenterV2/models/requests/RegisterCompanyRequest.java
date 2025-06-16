package com.example.careercenterV2.models.requests;

import lombok.Data;

@Data
public class RegisterCompanyRequest {
    String companyName;
    String email;
    String password;
}
