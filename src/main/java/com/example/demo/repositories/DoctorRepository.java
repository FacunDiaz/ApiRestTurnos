package com.example.demo.repositories;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//abstraction layer, or connection layer that allows data access logic to interact with the data persistence layer (physical database)

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
}
