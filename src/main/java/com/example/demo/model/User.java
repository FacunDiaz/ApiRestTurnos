package com.example.demo.model;

import com.example.demo.enums.HealthcareSystem;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    private String name;
    private long dni;
    private Date bornDate;
    private HealthcareSystem healthcareSys;

}
