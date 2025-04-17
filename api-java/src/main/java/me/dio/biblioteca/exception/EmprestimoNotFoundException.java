package me.dio.biblioteca.exception;

public class EmprestimoNotFoundException extends RuntimeException {
    public EmprestimoNotFoundException(String message) {
        super(message);
    }
}
