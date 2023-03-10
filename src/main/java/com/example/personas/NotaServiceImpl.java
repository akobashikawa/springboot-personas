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
    
    public List<Nota> getNotas() {
        return notaRepository.findAll();
    }

    public Nota saveNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Optional<Nota> getNota(Long id) {
        return notaRepository.findById(id);
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}
