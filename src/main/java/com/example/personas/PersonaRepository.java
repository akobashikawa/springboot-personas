package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository {
    
    List<Persona> findAll();
    Persona save(Persona persona);
    Optional<Persona> findById(Long id);
    void deleteById(Long id);
}
