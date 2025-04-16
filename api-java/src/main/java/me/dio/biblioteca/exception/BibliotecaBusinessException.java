package me.dio.biblioteca.exception;

public class BibliotecaBusinessException extends RuntimeException {
    public BibliotecaBusinessException(String message) {
        super(message);
    }
    
    public BibliotecaBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}