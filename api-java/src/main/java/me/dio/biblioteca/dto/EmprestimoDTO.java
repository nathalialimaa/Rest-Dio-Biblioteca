package me.dio.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoDTO(
        Long usuarioId,
        Long livroId,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucaoPrevista
) {}
