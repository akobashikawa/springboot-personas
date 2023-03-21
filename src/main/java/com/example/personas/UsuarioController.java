package com.example.personas;

import java.util.List;
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

import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioId) {
        Optional<Usuario> usuarioOp = usuarioService.getUsuario(usuarioId);
        if (usuarioOp.isPresent()) {
            Usuario usuario = usuarioOp.get();
            return ResponseEntity.ok().body(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PostMapping("/registro-usuario")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody JsonNode requestBody) {
        String email = requestBody.get("email").asText();
        String password = requestBody.get("password").asText();
        String nombre = requestBody.get("nombre").asText();
        Usuario newUsuario = usuarioService.registrarUsuario(email, password, nombre);
        return ResponseEntity.ok().body(newUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody JsonNode requestBody) {
        String email = requestBody.get("email").asText();
        String password = requestBody.get("password").asText();
        Optional<Usuario> usuarioOp = usuarioService.login(email, password);
        if (usuarioOp.isPresent()) {
            Usuario usuario = usuarioOp.get();
            return ResponseEntity.ok().body(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioId, @RequestBody Usuario usuarioBody) {
        Optional<Usuario> usuarioOp = usuarioService.getUsuario(usuarioId);
        if (usuarioOp.isPresent()) {
            Usuario usuario = usuarioOp.get();
            usuario.setEmail(usuarioBody.getEmail());
            usuario.setPassword(usuarioBody.getPassword());
            Usuario updatedUsuario = usuarioService.saveUsuario(usuario);
            return ResponseEntity.ok().body(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(value = "id") Long usuarioId) {
        Optional<Usuario> usuarioOp = usuarioService.getUsuario(usuarioId);
        if (usuarioOp.isPresent()) {
            usuarioService.deleteUsuario(usuarioId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
