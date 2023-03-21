package com.example.personas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NotaController {

    @Autowired
    private NotaService notaService;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/notas")
    public List<Nota> getNotas() {
        return notaService.getNotas();
    }

    @GetMapping("/personas/{personaId}/notas")
    public List<Nota> getNotasByPersonaId(@PathVariable(value = "personaId") Long personaId) {
        // existe la persona?
        Optional<Persona> personaOp = personaService.getPersona(personaId);
        if (personaOp.isPresent()) {
            // si existe
            Persona persona = personaOp.get();
            return notaService.getNotasForPersona(persona);
        } else {
            // si no existe
            return null;
        }
    }

    @GetMapping("/notas/{id}")
    public Optional<Nota> getNota(@PathVariable(value = "id") Long notaId) {
        return notaService.getNota(notaId);
    }

    @PostMapping("/notas")
    public ResponseEntity<Nota> createNota(@RequestBody Nota nota) {
        Nota newNota = notaService.saveNota(nota);
        return ResponseEntity.ok().body(newNota);
    }

    @PostMapping("/personas/{personaId}/notas")
    public ResponseEntity<Nota> createNotaForPersonaId(@PathVariable(value = "personaId") Long personaId, @RequestBody Nota nota) {
        Optional<Persona> personaOp = personaService.getPersona(personaId);
        if (personaOp.isPresent()) {
            Persona persona = personaOp.get();
            Nota newNota = notaService.saveNotaForPersona(persona, nota);
            return ResponseEntity.ok().body(newNota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable(value = "id") Long notaId, @RequestBody Nota notaBody) {
        Optional<Nota> notaOp = notaService.getNota(notaId);
        if (notaOp.isPresent()) {
            Nota nota = notaOp.get();
            nota.setTexto(notaBody.getTexto());
            // nota.setPersona(notaBody.getPersona());
            Nota updatedNota = notaService.saveNota(nota);
            return ResponseEntity.ok().body(updatedNota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/notas/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable(value = "id") Long notaId) {
        Optional<Nota> notaOp = notaService.getNota(notaId);
        if (notaOp.isPresent()) {
            notaService.deleteNota(notaId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
