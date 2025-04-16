package me.dio.biblioteca.util;

import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.enums.StatusLivro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    private final DateTimeFormatterUtil dateTimeFormatter;

    public LivroMapper(DateTimeFormatterUtil dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public Livro toEntity(LivroDTO dto) {
        return Livro.builder()
                .titulo(dto.titulo())
                .autor(dto.autor())
                .editora(dto.editora())
                .isbn(dto.isbn())
                .codigoBarras(dto.codigoBarras())
                .dataPublicacao(dto.dataPublicacao() != null ? 
                    dateTimeFormatter.parse(dto.dataPublicacao()) : null)
                .status(StatusLivro.DISPONIVEL) // Status padrão para novos livros
                .build();
    }

    public LivroDTO toDto(Livro entity) {
        return LivroDTO.builder()
                .titulo(entity.getTitulo())
                .autor(entity.getAutor())
                .editora(entity.getEditora())
                .isbn(entity.getIsbn())
                .codigoBarras(entity.getCodigoBarras())
                .dataPublicacao(entity.getDataPublicacao() != null ? 
                    dateTimeFormatter.format(entity.getDataPublicacao()) : null)
                .status(entity.getStatus())
                .build();
    }
}