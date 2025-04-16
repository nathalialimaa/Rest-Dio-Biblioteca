package me.dio.biblioteca.dto;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record RespostaEmprestimoDTO(
    Long id,
    String nomeUsuario,
    String tituloLivro,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucaoPrevista,
    String status
) {}