package com.example.careercenterV2.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;


    private String description;
    private String speciality;
    private String diplomeObtenue;
    private String ecole ;
    private String niveau ;
    private String city;
    private String state;
    private Date dateDebut;
    private Date dateFin;
    private String diplomeUrl;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student ;
}
