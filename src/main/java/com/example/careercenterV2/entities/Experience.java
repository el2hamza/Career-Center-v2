package com.example.careercenterV2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String poste;
    private String type;
    private String city;
    private String description;
    private String nomEntreprise;
    private String state;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
