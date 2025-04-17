package me.dio.biblioteca.service;

import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.entity.Emprestimo;

public interface EmprestimoService {

    Emprestimo saveEmprestimo(EmprestimoDTO emprestimoDTO);
}
