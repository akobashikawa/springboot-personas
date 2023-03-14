package com.example.personas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name="personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // @OneToMany(mappedBy = "persona")
    // private List<Nota> notas;

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

    // public void addNota(Nota nota) {
    //     notas.add(nota);
    // }

    // public List<Nota> getNotas() {
    //     return notas;
    // }

    // public void setNotas(List<Nota> notas) {
    //     this.notas = notas;
    // }
    

}