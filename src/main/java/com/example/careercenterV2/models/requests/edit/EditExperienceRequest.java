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
public class EditExperienceRequest {

    String poste;
    String type;
    String city;
    String description;
    String nomEntreprise;
    String state;
    Date dateDebut;
    Date dateFin;
}
