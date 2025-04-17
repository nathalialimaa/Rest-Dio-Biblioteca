package me.dio.biblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.mapper.LivroMapper;
import me.dio.biblioteca.repository.LivroRepository;
import me.dio.biblioteca.service.LivroService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    @Override
    public Livro saveLivro(LivroDTO livroDTO) {
        if (livroRepository.existsByTituloAndAutor(livroDTO.titulo(), livroDTO.autor())) {
            throw new IllegalArgumentException("Livro já cadastrado.");
        }

        return livroRepository.save(livroMapper.toEntity(livroDTO));
    }

    @Override
    public Livro findOrCreateLivro(LivroDTO livroDTO) {
        return livroRepository.findByTituloAndAutor(livroDTO.titulo(), livroDTO.autor())
                .orElseGet(() -> livroRepository.save(livroMapper.toEntity(livroDTO)));
    }
}
