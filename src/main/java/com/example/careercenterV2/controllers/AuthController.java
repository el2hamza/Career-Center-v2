package com.example.careercenterV2.controllers;

import com.example.careercenterV2.models.requests.AuthRequest;
import com.example.careercenterV2.models.requests.RegisterCompanyRequest;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.responses.AuthResponse;
import com.example.careercenterV2.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MessageSource messageSource;

    @PostMapping("/register/student")
    public ResponseEntity<?> register (@Valid @RequestBody RegisterStudentRequest student) {
        AuthResponse token = authService.registerStudent(student);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register/company")
    public ResponseEntity<?> register (@Valid @RequestBody RegisterCompanyRequest company) {
        AuthResponse token = authService.registerCompany(company);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@Valid @RequestBody AuthRequest request) {
        AuthResponse token = authService.login(request);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
