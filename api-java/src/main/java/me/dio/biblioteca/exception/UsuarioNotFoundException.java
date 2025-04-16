package me.dio.biblioteca.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }
    
    public UsuarioNotFoundException(Long id) {
        super("Usuário não encontrado com ID: " + id);
    }
    
    public UsuarioNotFoundException(String cpf, String tipo) {
        super("Usuário não encontrado com CPF: " + cpf);
    }
}