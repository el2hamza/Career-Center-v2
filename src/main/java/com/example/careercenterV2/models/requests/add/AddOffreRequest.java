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
public class AddOffreRequest {

     String reference;
     String titre;
     String description;
     String type;
     String secteur;
     String city;
     String state;
     Date datePublication;
     Date dateCloture;
     UUID companyId;
}
