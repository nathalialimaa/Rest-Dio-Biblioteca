package me.dio.biblioteca.dto;

import lombok.Builder;
import me.dio.biblioteca.enums.StatusLivro;
import java.time.LocalDate;

@Builder
public record LivroDTO(
    String titulo,
    String autor,
    String editora,
    String isbn,
    Integer codigoBarras,
    String dataPublicacao, // Alterado para String para formatação
    StatusLivro status
) {}