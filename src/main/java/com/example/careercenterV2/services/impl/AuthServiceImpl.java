package com.example.careercenterV2.services.impl;

import com.example.careercenterV2.entities.Company;
import com.example.careercenterV2.entities.Student;
import com.example.careercenterV2.models.requests.AuthRequest;
import com.example.careercenterV2.models.requests.RegisterCompanyRequest;
import com.example.careercenterV2.models.requests.RegisterStudentRequest;
import com.example.careercenterV2.models.responses.AuthResponse;
import com.example.careercenterV2.repositories.CompanyRepository;
import com.example.careercenterV2.repositories.StudentRepository;
import com.example.careercenterV2.security.AppUser;
import com.example.careercenterV2.security.JwtService;
import com.example.careercenterV2.services.AuthService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(StudentRepository studentRepository,
                           CompanyRepository companyRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse registerStudent(RegisterStudentRequest request) {
        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadCredentialsException("Email already exist");
        }
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPassword(passwordEncoder.encode(request.getPassword()));
        student.setPhone(request.getPhone());
        studentRepository.save(student);
        return new AuthResponse(jwtService.generateToken(student.getEmail(), "STUDENT"));

    }

    @Override
    public AuthResponse registerCompany(RegisterCompanyRequest request) {
        if (companyRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BadCredentialsException("Email already exist");
        }
        Company company = new Company();
        company.setName(request.getCompanyName());
        company.setEmail(request.getEmail());
        company.setPassword(passwordEncoder.encode(request.getPassword()));
        companyRepository.save(company);
        return new AuthResponse(jwtService.generateToken(company.getEmail(), "COMPANY"));

    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = null;
        if ("student".equalsIgnoreCase(request.getType())) {
            user = studentRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new BadCredentialsException("Student not found"));
        } else if ("company".equalsIgnoreCase(request.getType())) {
            user = companyRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new BadCredentialsException("Company not found"));
        } else {
            throw new BadCredentialsException("Invalid type");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        String token = jwtService.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token);
    }
}
