package me.dio.biblioteca.util;

import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.dto.RespostaEmprestimoDTO;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {

    private final DateTimeFormatterUtil dateTimeFormatter;

    public EmprestimoMapper(DateTimeFormatterUtil dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public Emprestimo toEntity(EmprestimoDTO dto, Usuario usuario, Livro livro) {
        return Emprestimo.builder()
                .usuario(usuario)
                .livro(livro)
                .dataEmprestimo(LocalDate.now())
                .dataDevolucaoPrevista(dateTimeFormatter.parse(dto.dataDevolucaoPrevista()))
                .status(StatusEmprestimo.ATIVO)
                .build();
    }

    public RespostaEmprestimoDTO toRespostaDto(Emprestimo entity) {
        return RespostaEmprestimoDTO.builder()
                .id(entity.getId())
                .nomeUsuario(entity.getUsuario().getNome())
                .tituloLivro(entity.getLivro().getTitulo())
                .dataEmprestimo(dateTimeFormatter.format(entity.getDataEmprestimo()))
                .dataDevolucaoPrevista(dateTimeFormatter.format(entity.getDataDevolucaoPrevista()))
                .status(entity.getStatus().toString())
                .build();
    }
}