package me.dio.biblioteca.mapper;

import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        return livro;
    }

    public LivroDTO toDto(Livro livro) {
        return new LivroDTO(
            livro.getTitulo(),
            livro.getAutor()
        );
    }
}
