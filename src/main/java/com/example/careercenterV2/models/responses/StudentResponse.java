package com.example.careercenterV2.models.responses;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
public class StudentResponse {

    UUID id;
    String name;
    String email;
    String phone;
    String address;
    String city;
    String cv;
    String description;
    String cin;
    String carteSejour;
    Date dateExpiration;
    String securiteSociale;
    String photo;
    Date dateOfBirth;
    List<String> skills;
}
