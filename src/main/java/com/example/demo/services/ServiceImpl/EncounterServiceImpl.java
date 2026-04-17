package com.example.demo.services.serviceImpl;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Encounter;
import com.example.demo.model.User;
import com.example.demo.repositories.EncounterRepository;
import com.example.demo.services.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncounterServiceImpl implements EncounterService {

    @Autowired
    private final EncounterRepository repository;

    public EncounterServiceImpl(EncounterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Encounter> findEncounter(long id) {
        Optional<Encounter> encounter = repository.findById(id);
        if(encounter.isEmpty()) throw new NotFoundException("No se encontró dicho usuario"+ id);
        return encounter;
    }

    @Override
    public List<Encounter> findAllEncounters() {
        return repository.findAll();
    }

    @Override
    public boolean deleteEncounter(long id) {
        try{
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.err.println("Deletion failed");
            return false;
        }
    }

    @Override
    public Encounter updateEncounter(long id, Encounter newEncounter) {
        try{
            Optional<Encounter> oldEncounter = repository.findById(id);
            newEncounter.setIdEncounter(oldEncounter.get().getIdEncounter());
            repository.save(newEncounter);
            return newEncounter;
        }catch (Exception E){
            System.err.println("Deletion failed");
            return null;
        }
    }
}
