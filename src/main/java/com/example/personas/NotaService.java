package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface NotaService {

    List<Nota> getNotas();
    List<Nota> getNotasForPersona(Persona persona);
    Nota saveNota(Nota nota);
    Nota saveNotaForPersona(Persona persona, Nota nota);
    Optional<Nota> getNota(Long id);
    void deleteNota(Long id);
}
