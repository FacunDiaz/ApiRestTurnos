package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDoctor;
    private String name;
    private String dni;
    private int yearsExp;
    private String description;
}
