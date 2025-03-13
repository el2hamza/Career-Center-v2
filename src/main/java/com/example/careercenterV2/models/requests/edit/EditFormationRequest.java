package com.example.careercenterV2.models.requests.edit;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Data
@Getter
@Setter
@NoArgsConstructor
public class EditFormationRequest {

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
}
