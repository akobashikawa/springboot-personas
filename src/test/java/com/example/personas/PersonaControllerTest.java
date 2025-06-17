package com.example.personas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HolaService holaService;

    @Test
    void testHolaMundo() throws Exception {
        // Mock del servicio - ahora retorna "Hola Mundo!" cuando recibe ""
        when(holaService.getSaludo("")).thenReturn("Hola Mundo!");
        
        mockMvc.perform(get("/holamundo"))
                // 1. Verificar que se devuelve un JSON
                .andExpect(content().contentType("application/json"))
                
                // 2. Verificar que tiene la propiedad "saludo"
                .andExpect(jsonPath("$.saludo").exists())
                
                // 3. Verificar que el valor del saludo es "Hola Mundo!"
                .andExpect(jsonPath("$.saludo").value("Hola Mundo!"));
    }

    @Test
    void testHola() throws Exception {
        // Mock del servicio
        when(holaService.getSaludo("Juan")).thenReturn("Hola Juan!");
        
        mockMvc.perform(post("/hola")
                // Enviar JSON via POST
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nombre\": \"Juan\"}"))
                
                // Verificar que devuelve JSON
                .andExpect(content().contentType("application/json"))
                
                // Verificar que tiene la propiedad "saludo"
                .andExpect(jsonPath("$.saludo").exists())
                
                // Verificar que el valor del saludo es "Hola Juan!"
                .andExpect(jsonPath("$.saludo").value("Hola Juan!"));
    }
}