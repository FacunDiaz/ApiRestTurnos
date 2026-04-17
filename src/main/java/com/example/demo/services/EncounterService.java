package com.example.demo.services;

import com.example.demo.model.Encounter;

import java.util.List;
import java.util.Optional;

public interface EncounterService {
    Optional<Encounter> findEncounter(long id);

    List<Encounter> findAllEncounters();

    boolean deleteEncounter(long id);

    Encounter updateEncounter(long id, Encounter newEncounter);

}
