package me.dio.biblioteca.exception;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(String message) {
        super(message);
    }
}
