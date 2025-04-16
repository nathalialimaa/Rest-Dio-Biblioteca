package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.status(201)
                .body("Usuário cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<Object> buscarPorCpf(@RequestParam String cpf) {
        return ResponseEntity.status(200).body(usuarioService.buscarPorCpf(cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(usuarioService.buscarPorId(id));
    }
}