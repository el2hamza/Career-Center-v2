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
public class EditOffreRequest {

    String titre;
    String description;
    String type;
    String secteur;
    String city;
    String state;
    Date dateCloture;
}
