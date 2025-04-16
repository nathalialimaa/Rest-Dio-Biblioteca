package me.dio.biblioteca.exception;

public class LivroNotFoundException extends RuntimeException {
    
    // Construtor principal que aceita qualquer mensagem
    public LivroNotFoundException(String message) {
        super(message);
    }
    
    // Construtor alternativo que recebe o ID
    public LivroNotFoundException(Long id) {
        this("Livro não encontrado com ID: " + id); // Chama o construtor principal
    }
    
    // Construtor alternativo que recebe o ISBN
    public LivroNotFoundException(String isbn, boolean isIsbn) {
        this("Livro não encontrado com ISBN: " + isbn); // Chama o construtor principal
    }
}