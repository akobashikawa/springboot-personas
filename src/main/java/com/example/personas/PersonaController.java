package com.example.personas;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PersonaController {
    
    @GetMapping("/holamundo")
    public ResponseEntity<Map<String, String>> holamundo() {
        Map<String, String> response = new HashMap<>();
        response.put("saludo", "Hola Mundo!");
        return ResponseEntity.ok(response);
    }

}
