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
        return notaRepository.getNotas();
    }

    public Nota saveNota(Nota nota) {
        return notaRepository.saveNota(nota);
    }

    public Optional<Nota> getNota(Long id) {
        return notaRepository.getNota(id);
    }

    public void deleteNota(Long id) {
        notaRepository.deleteNota(id);
    }
}
