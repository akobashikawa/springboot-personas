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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@Tag(name = "Saludos", description = "API para gestión de saludos")
public class HolaController {

    @Autowired
    private HolaService holaService;

    @Operation(summary = "Saludo genérico", description = "Devuelve 'Hola Mundo!'")
    @ApiResponse(responseCode = "200", description = "Saludo exitoso")
    @GetMapping("/holamundo")
    public ResponseEntity<Map<String, String>> holamundo() {
        Map<String, String> response = new HashMap<>();
        String saludo = holaService.getSaludo("");
        response.put("saludo", saludo);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Saludo personalizado", description = "Devuelve saludo personalizado con el nombre proporcionado")
    @ApiResponse(responseCode = "200", description = "Saludo personalizado exitoso")
    @PostMapping("/hola")
    public ResponseEntity<Map<String, String>> hola(
        @Parameter(description = "Datos de la persona para personalizar el saludo", required = true)
        @RequestBody Persona persona) {
        Map<String, String> response = new HashMap<>();
        String saludo = holaService.getSaludo(persona.getNombre());
        response.put("saludo", saludo);
        return ResponseEntity.ok(response);
    }
}