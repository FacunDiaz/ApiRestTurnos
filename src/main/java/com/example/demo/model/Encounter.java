package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Encounters")
public class Encounter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEncounter;

    private Date date;
    private String additionalComments;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_User")
    private Doctor doctor;

    public Encounter(long idEncounter, Date date, String additionalComments, User user, Doctor doctor) {
        this.idEncounter = idEncounter;
        this.date = date;
        this.additionalComments = additionalComments;
        this.user = user;
        this.doctor = doctor;
    }

    public long getIdEncounter() {
        return idEncounter;
    }

    public void setIdEncounter(long idEncounter) {
        this.idEncounter = idEncounter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
