package com.example.personas;

import org.springframework.stereotype.Service;

@Service
public class HolaService {
    
    public String getSaludo(String nombre) {
        // Si nombre es null o está en blanco, usar "Mundo"
        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Mundo";
        }
        
        return "Hola " + nombre + "!";
    }
}