package com.example.personas;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends ArrayRepository<Persona, Long> {
    
}
