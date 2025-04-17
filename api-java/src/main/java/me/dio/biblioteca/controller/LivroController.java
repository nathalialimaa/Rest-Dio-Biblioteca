package me.dio.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.saveLivro(livroDTO);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<Livro> getLivro(
            @RequestParam String titulo,
            @RequestParam String autor
    ) {
        Livro livro = livroService.findOrCreateLivro(new LivroDTO(titulo, autor));
        return ResponseEntity.ok(livro);
    }
}
