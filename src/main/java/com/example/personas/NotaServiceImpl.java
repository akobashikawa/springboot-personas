package com.example.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl implements NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private PersonaRepository personaRepository;
    
    public List<Nota> getNotas() {
        return notaRepository.findAll();
    }

    public List<Nota> getNotasForPersona(Persona persona) {
        return notaRepository.findByPersona(persona);
    }

    public Nota saveNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota saveNotaForPersona(Persona persona, Nota nota) {
        nota.setPersona(persona);
        Nota savedNota = notaRepository.save(nota);
        // persona.addNota(savedNota);
        // Persona savedPersona = personaRepository.save(persona);
        return savedNota;
    }

    public Optional<Nota> getNota(Long id) {
        return notaRepository.findById(id);
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}
