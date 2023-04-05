package com.example.personas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/notas")
    public List<Nota> getNotas() {
        return notaService.getNotas();
    }

    @GetMapping("/notas/{id}")
    public Optional<Nota> getNota(@PathVariable(value = "id") Long notaId) {
        return notaService.getNota(notaId);
    }

    @PostMapping("/notas")
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.saveNota(nota);
    }

    @PutMapping("/notas/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable(value = "id") Long notaId, @RequestBody Nota notaBody) {
        Optional<Nota> notaOp = notaService.getNota(notaId);
        if (notaOp.isPresent()) {
            Nota nota = notaOp.get();
            nota.setTexto(notaBody.getTexto());
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
