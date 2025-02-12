package com.example.careercenterV2.models.responses;

import java.util.Date;
import java.util.UUID;

public class AddExperienceResponse {

    long id ;
    String poste;
    String type;
    String city;
    String description;
    String experienceDate;
    String nomEntreprise;
    String state;
    Date dateDebut;
    Date dateFin;

    UUID studentId ;
}
