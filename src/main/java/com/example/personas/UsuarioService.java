package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario usuario);
    Optional<Usuario> getUsuario(Long id);
    Optional<Usuario> login(String email, String password);
    void deleteUsuario(Long id);
    Usuario registrarUsuario(String email, String password, String nombre);
}