package com.example.personas;

import java.util.List;

public interface PersonaService {

    List<Persona> findAll();

    Persona save(Persona persona);

}