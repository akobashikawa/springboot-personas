package com.example.personas;

import org.springframework.stereotype.Service;

@Service
public class HolaService {

    private String saludo = "";

    public String getSaludo(String nombre) {
        if (nombre == "") {
            this.saludo = "Hola Mundo!";
        } else {
            this.saludo = "Hola " + nombre + "!";
        }
        return this.saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

}