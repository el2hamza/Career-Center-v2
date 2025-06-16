package com.example.careercenterV2.services;

import com.example.careercenterV2.models.requests.AuthRequest;
import com.example.careercenterV2.models.requests.RegisterCompanyRequest;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.responses.AuthResponse;


public interface AuthService {
    AuthResponse registerStudent(RegisterStudentRequest request);
    AuthResponse registerCompany(RegisterCompanyRequest request);
    AuthResponse login(AuthRequest request);
}
