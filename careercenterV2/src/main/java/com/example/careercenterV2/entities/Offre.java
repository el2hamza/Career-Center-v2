package com.example.careercenterV2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String titre;
    private String description;
    private String type;
    private String secteur;
    private String city;
    private String state;
    private Date datePublication;
    private Date dateCloture;




}
