package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Specialities")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSpecialty;
    private String name;
    //private cantidad de médicos
    @OneToMany(mappedBy = "specialty")
    private List<Doctor> doctorList;

    public Specialty(String name, List<Doctor> doctorList, long idSpecialty) {
        this.idSpecialty = idSpecialty;
        this.name = name;
        this.doctorList = new ArrayList<>();
    }

    public long getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(long idSpecialty) {
        this.idSpecialty = idSpecialty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void addToDoctorList(Doctor doctor) {
        this.doctorList.add(doctor);
    }

    public void removeFromDoctorList(Doctor doctor){
        this.doctorList.remove(doctor);
    }
}
