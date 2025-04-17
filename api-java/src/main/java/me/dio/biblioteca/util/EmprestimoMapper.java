package me.dio.biblioteca.mapper;

import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.entity.Usuario;
import me.dio.biblioteca.enums.StatusEmprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    public Emprestimo toEntity(EmprestimoDTO dto, Usuario usuario, Livro livro) {
        return Emprestimo.builder()
                .usuario(usuario)
                .livro(livro)
                .dataEmprestimo(dto.dataEmprestimo())
                .dataDevolucaoPrevista(dto.dataDevolucaoPrevista())
                .status(StatusEmprestimo.ATIVO)
                .build();
    }
}
