package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    List<Persona> getPersonas();
    Persona savePersona(Persona persona);
    Optional<Persona> getPersona(Long id);
    void deletePersona(Long id);
}