package me.dio.biblioteca.exception;

public class OperacaoInvalidaException extends RuntimeException {
    public OperacaoInvalidaException(String message) {
        super(message);
    }
}