package com.example.personas;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {

    @Autowired
    private HolaService holaService;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/holamundo")
    public HashMap<String, String> holamundo() {
        HashMap<String, String> map = new HashMap<>();
        String saludo = holaService.getSaludo("");
        map.put("saludo", saludo);
        return map;
    }

    @PostMapping("/hola")
    public HashMap<String, String> hola(@RequestBody Persona persona) {
        HashMap<String, String> map = new HashMap<>();
        String nombre = persona.getNombre();
        String saludo = holaService.getSaludo(nombre);
        map.put("saludo", saludo);
        return map;
    }

    @GetMapping("/personas")
    public List<Persona> getPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable(value = "id") Long personaId) {
        Optional<Persona> personaOp = personaService.findById(personaId);
        if (personaOp.isPresent()) {
            Persona persona = personaOp.get();
            return ResponseEntity.ok().body(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/personas")
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable(value = "id") Long personaId, @RequestBody Persona personaBody) {
        Optional<Persona> personaOp = personaService.findById(personaId);
        if (personaOp.isPresent()) {
            Persona persona = personaOp.get();
            persona.setNombre(personaBody.getNombre());
            Persona updatedPersona = personaService.save(persona);
            return ResponseEntity.ok().body(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable(value = "id") Long personaId) {
        Optional<Persona> personaOp = personaService.findById(personaId);
        if (personaOp.isPresent()) {
            personaService.deleteById(personaId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
