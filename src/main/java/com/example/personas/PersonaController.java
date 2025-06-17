package com.example.personas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {

    @Autowired
    private HolaService holaService;

    @GetMapping("/holamundo")
    public ResponseEntity<Map<String, String>> holamundo() {
        Map<String, String> response = new HashMap<>();
        String saludo = holaService.getSaludo("");
        response.put("saludo", saludo);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/hola")
    public ResponseEntity<HashMap<String, String>> hola(@RequestBody Persona persona) {
        HashMap<String, String> response = new HashMap<>();
        String nombre = persona.getNombre();
        String saludo = holaService.getSaludo(nombre);
        response.put("saludo", saludo);
        return ResponseEntity.ok(response);
    }

}
