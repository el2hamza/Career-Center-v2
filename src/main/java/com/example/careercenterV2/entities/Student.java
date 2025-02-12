package com.example.careercenterV2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String cv;
    private String password;
    private String description;
    private String cin;
    private String carteSejour;
    private Date dateExpiration ;
    private String securiteSociale ;
    private String photo;
    private Date dateOfBirth;

    @ElementCollection
    @CollectionTable(name = "student_skills", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill")
    private List<String> skills;
}
