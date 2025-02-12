package com.example.careercenterV2.models.requests;

import java.util.Date;
import java.util.UUID;

public class AddOffreRequest {

     String titre;
     String description;
     String type;
     String secteur;
     String city;
     String state;
     Date datePublication;
     Date dateCloture;

     UUID companyId ;
}
