package com.example.careercenterV2.models.requests;

import lombok.Data;

@Data
public class AuthRequest {
    String email;
    String password;
    String type ;
}
