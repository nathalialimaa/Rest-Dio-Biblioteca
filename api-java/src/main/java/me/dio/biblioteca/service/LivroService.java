package me.dio.biblioteca.service;

import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;

import java.util.List;

public interface LivroService {
    void cadastrarLivro(LivroDTO livroDTO);
    LivroDTO buscarPorId(Long id);
    List<LivroDTO> listarTodos();
    LivroDTO atualizar(Long id, LivroDTO livroDTO);
    void deletar(Long id);
}