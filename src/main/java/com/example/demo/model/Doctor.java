package com.example.demo.model;


import jakarta.persistence.*;
import org.springframework.beans.factory.BeanRegistry;

import java.util.List;

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

    @OneToMany(mappedBy = "doctor")
    private List<Encounter> encounterList;

    @ManyToOne
    @JoinColumn(name = "id_Specialty")
    private Specialty specialty;

    public Doctor(long idDoctor, String name, String dni, int yearsExp, String description, List<Encounter> encounterList, Specialty specialty) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.dni = dni;
        this.yearsExp = yearsExp;
        this.description = description;
        this.encounterList = encounterList;
        this.specialty = specialty;
    }

    public long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(int yearsExp) {
        this.yearsExp = yearsExp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Encounter> getEncounterList() {
        return encounterList;
    }

    public void setEncounterList(List<Encounter> encounterList) {
        this.encounterList = encounterList;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
