package me.dio.biblioteca.controller.advice;

import me.dio.biblioteca.exception.LivroNotFoundException;
import me.dio.biblioteca.exception.UsuarioNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationAdvice {

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> handlerUsuarioNotFoundException(UsuarioNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(LivroNotFoundException.class)
    public ResponseEntity<String> handlerLivroNotFoundException(LivroNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}