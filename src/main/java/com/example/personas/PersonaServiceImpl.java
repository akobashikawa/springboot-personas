package com.example.personas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    private List<Persona> personas = new ArrayList<>();
    private Long idActual = 0L;
    
    @Override
    public List<Persona> findAll() {
        return personas;
    }

    @Override
    public Persona save(Persona persona) {
        if (persona.getId() == null) {
            idActual++;
            persona.setId(idActual);
            personas.add(persona);
        } else {
            int index = personas.indexOf(persona);
            if (index >= 0) {
                personas.set(index, persona);
            } else {
                personas.add(persona);
            }
        }
        return persona;
    }

    
    
}