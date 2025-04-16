package me.dio.biblioteca.enums;

public enum StatusLivro {
    DISPONIVEL,       // Livro disponível para empréstimo
    EMPRESTADO,       // Livro atualmente emprestado
    RESERVADO,        // Livro reservado por um usuário
    EM_MANUTENCAO,    // Livro indisponível para empréstimo
    DANIFICADO;       // Livro danificado e não disponível
}