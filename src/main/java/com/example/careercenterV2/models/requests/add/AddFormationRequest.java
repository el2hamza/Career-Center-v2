package com.example.careercenterV2.models.requests.add;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Data
@Getter @Setter
@NoArgsConstructor
public class AddFormationRequest {
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
