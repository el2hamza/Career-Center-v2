package com.example.careercenterV2.models.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudentRequest {
    String name;
    String email;
    String password;
    String phone;
}
