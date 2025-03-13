package com.example.careercenterV2.models.responses;

import lombok.*;

import java.util.Date;
import java.util.UUID;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceResponse {

    long id ;
    String poste;
    String type;
    String city;
    String description;
    String nomEntreprise;
    String state;
    Date dateDebut;
    Date dateFin;
    UUID studentId ;
}
