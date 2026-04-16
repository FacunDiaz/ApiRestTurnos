package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Specialities")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSpecialty;
    private String name;
    //private cantidad de médicos
}
