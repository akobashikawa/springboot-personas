package com.example.personas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class NotaRepositoryImpl implements NotaRepository {
    
    private List<Nota> notas = new ArrayList<>();
    private Long idActual = 0L;

    public List<Nota> findAll() {
        return notas;
    }

    public Nota save(Nota nota) {
        if (nota.getId() == null) {
            idActual++;
            nota.setId(idActual);
            notas.add(nota);
        } else {
            int index = notas.indexOf(nota);
            if (index >= 0) {
                notas.set(index, nota);
            } else {
                notas.add(nota);
            }
        }
        return nota;
    }

    public Optional<Nota> findById(Long id) {
        return notas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        notas.removeIf(p -> p.getId().equals(id));
    }

}