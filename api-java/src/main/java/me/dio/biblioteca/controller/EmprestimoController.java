package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/emprestimo")
@RestController
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<String> realizarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        emprestimoService.realizarEmprestimo(emprestimoDTO);
        return ResponseEntity.status(201).body("Empréstimo realizado com sucesso");
    }

    @PostMapping("/devolucao/{id}")
    public ResponseEntity<String> registrarDevolucao(@PathVariable Long id) {
        emprestimoService.registrarDevolucao(id);
        return ResponseEntity.status(200).body("Devolução registrada com sucesso");
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<EmprestimoDTO>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.status(200).body(emprestimoService.listarPorUsuario(usuarioId));
    }
}