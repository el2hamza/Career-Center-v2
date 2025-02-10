package com.example.careercenterV2.models.requests;


import lombok.Data;

@Data
public class RegisterStudentRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
}
