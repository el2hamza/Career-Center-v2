package com.example.careercenterV2.models.responses;

import lombok.*;

import java.util.Date;


@Builder
public class OffreResponse {

    long id ;
    String reference;
    String titre;
    String description;
    String type;
    String secteur;
    String city;
    String state;
    Date datePublication;
    Date dateCloture;
}
