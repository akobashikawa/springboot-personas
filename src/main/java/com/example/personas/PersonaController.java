package com.example.personas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {
    
    @GetMapping("/holamundo")
    public Map<String, String> holamundo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("saludo", "Hola Mundo!");
        return map;
    }
}
