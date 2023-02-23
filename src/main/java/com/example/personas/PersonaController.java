package com.example.personas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @GetMapping("/holamundo")
    public Map<String, String> holamundo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("saludo", "Hola Mundo!");
        return map;
    }

    @PostMapping("/hola")
    public Map<String, String> hola(@RequestBody Persona persona) {
        HashMap<String, String> map = new HashMap<>();
        String nombre = persona.getNombre();
        map.put("saludo", "Hola " + nombre + "!");
        return map;
    }
}
