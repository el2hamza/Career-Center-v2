package com.example.careercenterV2.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String poste;
    private String type;
    private String city;
    private String description;
    private String experienceDate;
    private String nomEntreprise;
    private String state;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
