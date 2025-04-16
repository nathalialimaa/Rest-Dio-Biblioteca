package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/livros")  // Alterado para plural (melhor prática REST)
@RestController
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody LivroDTO livroDTO) {
        livroService.cadastrarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Livro cadastrado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @GetMapping("/isbn/{isbn}")  // Alterado para path variable (mais RESTful)
    public ResponseEntity<LivroDTO> buscarPorIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(livroService.buscarPorIsbn(isbn));
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listarTodos() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> atualizar(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.atualizar(id, livroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}