package com.example.careercenterV2.models.requests.add;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Data
@Getter
@Setter
@NoArgsConstructor

public class AddExperienceRequest {

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
