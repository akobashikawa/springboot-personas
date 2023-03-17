package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> getUsuarios();
    Usuario saveUsuario(Usuario persona);
    Optional<Usuario> getUsuario(Long id);
    void deleteUsuario(Long id);
}