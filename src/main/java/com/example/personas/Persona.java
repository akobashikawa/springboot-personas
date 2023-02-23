package com.example.personas;

public class Persona {
    
    private Long id;
    private String nombre;

    public Persona() {
        // Constructor vacío necesario para JPA
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
