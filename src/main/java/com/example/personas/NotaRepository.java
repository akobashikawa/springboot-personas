package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface NotaRepository {
    
    List<Nota> findAll();
    Nota save(Nota nota);
    Optional<Nota> findById(Long id);
    void deleteById(Long id);
}
