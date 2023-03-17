package com.example.personas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona savePersonaForUsuario(Usuario usuario, Persona persona) {
        persona.setUsuario(usuario);
        Persona savedPersona = personaRepository.save(persona);
        return savedPersona;
    }
    

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
    
}