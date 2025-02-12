package com.example.careercenterV2.models.responses;

import java.util.Date;
import java.util.UUID;

public class AddFormationResponse {

    long id ;
    String description;
    String speciality;
    String diplomeObtenue;
    String ecole ;
    String niveau ;
    String city;
    String state;
    Date dateDebut;
    Date dateFin;
    String diplomeUrl;

    UUID studentId ;
}
