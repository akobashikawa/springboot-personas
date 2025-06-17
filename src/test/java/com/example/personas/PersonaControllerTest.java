package com.example.personas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonaController.class)
class PersonaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHolaMundo() throws Exception {
        mockMvc.perform(get("/holamundo"))
                // 1. Verificar que se devuelve un JSON
                .andExpect(content().contentType("application/json"))
                
                // 2. Verificar que tiene la propiedad "saludo"
                .andExpect(jsonPath("$.saludo").exists())
                
                // 3. Verificar que el valor del saludo es "Hola Mundo!"
                .andExpect(jsonPath("$.saludo").value("Hola Mundo!"));
    }
}