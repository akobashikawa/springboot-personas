package com.example.personas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

class HolaServiceTest {

    private HolaService holaService;

    @BeforeEach
    void setUp() {
        holaService = new HolaService();
    }

    @Test
    void getSaludo_ConNombreVacio_DeberiaRetornarHolaMundo() {
        // Given
        String nombre = "";
        
        // When
        String resultado = holaService.getSaludo(nombre);
        
        // Then
        assertThat(resultado).isEqualTo("Hola Mundo!");
    }

    @Test
    void getSaludo_ConNombreNull_DeberiaRetornarHolaMundo() {
        // Given
        String nombre = null;
        
        // When
        String resultado = holaService.getSaludo(nombre);
        
        // Then
        assertThat(resultado).isEqualTo("Hola Mundo!");
    }

    @Test
    void getSaludo_ConNombreSoloEspacios_DeberiaRetornarHolaMundo() {
        // Given
        String nombre = "   ";
        
        // When
        String resultado = holaService.getSaludo(nombre);
        
        // Then
        assertThat(resultado).isEqualTo("Hola Mundo!");
    }

    @Test
    void getSaludo_ConNombreValido_DeberiaRetornarHolaNombre() {
        // Given
        String nombre = "Juan";
        
        // When
        String resultado = holaService.getSaludo(nombre);
        
        // Then
        assertThat(resultado).isEqualTo("Hola Juan!");
    }
}