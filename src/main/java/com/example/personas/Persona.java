package com.example.personas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name="personas")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "usuario_id")
    // private Usuario usuario;

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

    // public Usuario getUsuario() {
    //     return usuario;
    // }

    // public void setUsuario(Usuario usuario) {
    //     this.usuario = usuario;
    // }

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