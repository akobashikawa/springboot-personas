package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface NotaRepository {
    
    List<Nota> getNotas();
    Nota saveNota(Nota nota);
    Optional<Nota> getNota(Long id);
    void deleteNota(Long id);
}
