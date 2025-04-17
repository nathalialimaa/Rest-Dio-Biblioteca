package me.dio.biblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.EmprestimoDTO;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.entity.Usuario;
import me.dio.biblioteca.enums.StatusEmprestimo;
import me.dio.biblioteca.mapper.EmprestimoMapper;
import me.dio.biblioteca.repository.EmprestimoRepository;
import me.dio.biblioteca.repository.LivroRepository;
import me.dio.biblioteca.repository.UsuarioRepository;
import me.dio.biblioteca.service.EmprestimoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;
    private final EmprestimoMapper emprestimoMapper;

    @Override
    public Emprestimo saveEmprestimo(EmprestimoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(dto.livroId())
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        boolean livroJaEmprestado = emprestimoRepository.existsByLivroAndStatus(livro, StatusEmprestimo.ATIVO);
        if (livroJaEmprestado) {
            throw new IllegalStateException("Livro já está emprestado");
        }

        Emprestimo emprestimo = emprestimoMapper.toEntity(dto, usuario, livro);
        return emprestimoRepository.save(emprestimo);
    }
}
