package com.example.careercenterV2.models.requests;


import lombok.Data;

@Data
public class RegisterStudentRequest {
    String name;
    String email;
    String password;
    String phone;
}
