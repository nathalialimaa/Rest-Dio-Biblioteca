package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;
import me.dio.biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.saveUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable String cpf) {
        UsuarioDTO usuario = usuarioService.find(cpf);
        return ResponseEntity.ok(usuario);
    }
}
