package com.example.careercenterV2.models.requests;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCompanyRequest {
    String companyName;
    String email;
    String password;
}
