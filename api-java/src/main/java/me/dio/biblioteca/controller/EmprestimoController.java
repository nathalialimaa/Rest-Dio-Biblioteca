package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoService.saveEmprestimo(emprestimoDTO);
        return ResponseEntity.ok(emprestimo);
    }
}
