package com.example.careercenterV2.models.requests.add;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProfileStudentRequest {

    private String address;
    private String city;
    private String cv;
    private String description;
    private String cin;
    private String carteSejour;
    private Date dateExpiration;
    private String securiteSociale;
    private String photo;
    private Date dateOfBirth;
    private List<String> skills;
}
