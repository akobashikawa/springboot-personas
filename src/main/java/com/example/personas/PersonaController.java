package com.example.personas;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
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

}
