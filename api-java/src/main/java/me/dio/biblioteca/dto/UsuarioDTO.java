package me.dio.biblioteca.dto;

import lombok.Builder;

@Builder 

public record UsuarioDTO(String nome, String cpf) {}
