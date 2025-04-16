package me.dio.biblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.LivroDTO;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.enums.StatusLivro;
import me.dio.biblioteca.exception.LivroNotFoundException;
import me.dio.biblioteca.exception.OperacaoInvalidaException;
import me.dio.biblioteca.repository.LivroRepository;
import me.dio.biblioteca.service.LivroService;
import me.dio.biblioteca.util.LivroMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    @Override
    @Transactional
    public void cadastrarLivro(LivroDTO livroDTO) {
        validarDadosLivroAntesCadastro(livroDTO);
        
        Livro livro = livroMapper.toEntity(livroDTO);
        livro.setStatus(StatusLivro.DISPONIVEL);
        
        try {
            livroRepository.save(livro);
        } catch (DataIntegrityViolationException e) {
            throw new OperacaoInvalidaException("Erro ao cadastrar livro - dados inválidos ou duplicados");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public LivroDTO buscarPorId(Long id) {
        return livroRepository.findById(id)
                .map(livroMapper::toDto)
                .orElseThrow(() -> new LivroNotFoundException(id));
    }

    @Override
    @Transactional(readOnly = true)
    public LivroDTO buscarPorIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn)
                .map(livroMapper::toDto)
                .orElseThrow(() -> new LivroNotFoundException("Livro com ISBN " + isbn + " não encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LivroDTO> listarTodos() {
        return livroRepository.findAll().stream()
                .map(livroMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LivroDTO atualizar(Long id, LivroDTO livroDTO) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));

        validarDadosLivroAntesAtualizacao(livroDTO, livroExistente);
        
        Livro livroAtualizado = livroMapper.toEntity(livroDTO);
        atualizarDadosLivro(livroExistente, livroAtualizado);
        
        return livroMapper.toDto(livroRepository.save(livroExistente));
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));
        
        if (livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new OperacaoInvalidaException("Não é possível deletar um livro que não está disponível");
        }
        
        livroRepository.delete(livro);
    }

    private void validarDadosLivroAntesCadastro(LivroDTO livroDTO) {
        if (livroRepository.existsByIsbn(livroDTO.isbn())) {
            throw new OperacaoInvalidaException("Já existe um livro cadastrado com este ISBN");
        }
        
        if (livroDTO.codigoBarras() != null && livroRepository.existsByCodigoBarras(livroDTO.codigoBarras())) {
            throw new OperacaoInvalidaException("Já existe um livro cadastrado com este código de barras");
        }
    }

    private void validarDadosLivroAntesAtualizacao(LivroDTO livroDTO, Livro livroExistente) {
        if (!livroExistente.getIsbn().equals(livroDTO.isbn()) && livroRepository.existsByIsbn(livroDTO.isbn())) {
            throw new OperacaoInvalidaException("Já existe outro livro com este ISBN");
        }
        
        if (livroDTO.codigoBarras() != null && 
            !livroDTO.codigoBarras().equals(livroExistente.getCodigoBarras()) && 
            livroRepository.existsByCodigoBarras(livroDTO.codigoBarras())) {
            throw new OperacaoInvalidaException("Já existe outro livro com este código de barras");
        }
    }

    private void atualizarDadosLivro(Livro livroExistente, Livro livroAtualizado) {
        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setAutor(livroAtualizado.getAutor());
        livroExistente.setEditora(livroAtualizado.getEditora());
        livroExistente.setIsbn(livroAtualizado.getIsbn());
        livroExistente.setCodigoBarras(livroAtualizado.getCodigoBarras());
        livroExistente.setDataPublicacao(livroAtualizado.getDataPublicacao());
        // Mantém o status original e não atualiza o usuário de empréstimo
    }
}