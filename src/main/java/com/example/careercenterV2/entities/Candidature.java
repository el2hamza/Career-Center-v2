package com.example.careercenterV2.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Student candidat;

    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    private Date dateSoumission ;
    private String status ;

}
