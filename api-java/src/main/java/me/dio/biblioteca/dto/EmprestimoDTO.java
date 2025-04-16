package me.dio.biblioteca.dto;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record EmprestimoDTO(
    Long usuarioId,
    Long livroId,
    LocalDate dataEmprestimo,
    LocalDate dataDevolucaoPrevista
) {}