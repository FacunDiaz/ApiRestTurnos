package com.example.demo.model;

import com.example.demo.enums.HealthcareSystem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<Encounter> encounterList;

    public User(long idUser, String name, long dni, Date bornDate, HealthcareSystem healthcareSys, List<Encounter> encounterList) {
        this.idUser = idUser;
        this.name = name;
        this.dni = dni;
        this.bornDate = bornDate;
        this.healthcareSys = healthcareSys;
        this.encounterList = new ArrayList<>(); //composición, si no existe el usuario no pueden existir los turnos
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public HealthcareSystem getHealthcareSys() {
        return healthcareSys;
    }

    public void setHealthcareSys(HealthcareSystem healthcareSys) {
        this.healthcareSys = healthcareSys;
    }

    public List<Encounter> getEncounterList() {
        return encounterList;
    }

    public void addFromEncounterList(Encounter encounter) {
        this.encounterList.add(encounter);
    }

    public void removeFromEncounterList(Encounter encounter) {
        this.encounterList.remove(encounter);
    }
}
