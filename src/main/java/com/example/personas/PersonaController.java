package com.example.personas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@CrossOrigin(origins = "*")
@RestController
@Tag(name = "API Personas", description = "API para gestión de saludos y personas")
public class PersonaController {

    @Autowired
    private HolaService holaService;

    @Autowired
    private PersonaService personaService;

    // ENDPOINTS DE SALUDO
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
    public ResponseEntity<Map<String, String>> hola(@RequestBody Persona persona) {
        Map<String, String> response = new HashMap<>();
        String saludo = holaService.getSaludo(persona.getNombre());
        response.put("saludo", saludo);
        return ResponseEntity.ok(response);
    }

    // ENDPOINTS DE PERSONAS
    @Operation(
        summary = "Obtener todas las personas",
        description = "Obtiene una lista de todas las personas registradas en el sistema"
    )
    @ApiResponse(
        responseCode = "200", 
        description = "Lista de personas obtenida exitosamente",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))
    )
    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }

    @Operation(
        summary = "Obtener persona por ID",
        description = "Obtiene una persona específica mediante su ID único"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Persona encontrada exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Persona no encontrada",
            content = @Content
        )
    })
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(
        @Parameter(description = "ID único de la persona", required = true, example = "1")
        @PathVariable(value = "id") Long personaId) {
        Optional<Persona> persona = personaService.findById(personaId);
        if (persona.isPresent()) {
            return ResponseEntity.ok(persona.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
        summary = "Crear nueva persona",
        description = "Crea una nueva persona en el sistema con los datos proporcionados"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Persona creada exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "Datos de entrada inválidos",
            content = @Content
        )
    })
    @PostMapping("/personas")
    public ResponseEntity<Persona> createPersona(
        @Parameter(description = "Datos de la persona a crear", required = true)
        @RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        return ResponseEntity.ok(savedPersona);
    }

    @Operation(
        summary = "Actualizar persona existente",
        description = "Actualiza los datos de una persona existente identificada por su ID"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Persona actualizada exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Persona no encontrada",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "Datos de entrada inválidos",
            content = @Content
        )
    })
    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> updatePersona(
        @Parameter(description = "ID único de la persona a actualizar", required = true, example = "1")
        @PathVariable(value = "id") Long personaId,
        @Parameter(description = "Nuevos datos de la persona", required = true)
        @RequestBody Persona personaBody) {
        Optional<Persona> persona = personaService.findById(personaId);
        if (persona.isPresent()) {
            Persona existingPersona = persona.get();
            existingPersona.setNombre(personaBody.getNombre());
            Persona updatedPersona = personaService.save(existingPersona);
            return ResponseEntity.ok(updatedPersona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
        summary = "Eliminar persona",
        description = "Elimina una persona del sistema mediante su ID único"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204", 
            description = "Persona eliminada exitosamente"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Persona no encontrada",
            content = @Content
        )
    })
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Void> deletePersona(
        @Parameter(description = "ID único de la persona a eliminar", required = true, example = "1")
        @PathVariable(value = "id") Long personaId) {
        Optional<Persona> persona = personaService.findById(personaId);
        if (persona.isPresent()) {
            personaService.deleteById(personaId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
