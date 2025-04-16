package me.dio.biblioteca.service.impl;
import me.dio.biblioteca.service.EmprestimoService;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;
import me.dio.biblioteca.dto.EmprestimoDTO;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoMapper emprestimoMapper;

    public EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository, EmprestimoMapper emprestimoMapper) {
        this.emprestimoRepository = emprestimoRepository;
        this.emprestimoMapper = emprestimoMapper;
    }

    public Emprestimo salvarEmprestimo(EmprestimoDTO emprestimoRequest) {
        // Aqui você pode adicionar validações como: livro disponível, usuário com limite de empréstimos, etc.

        return emprestimoRepository.save(
                emprestimoMapper.toEntity(emprestimoRequest));
    }

    public EmprestimoDTO buscarEmprestimoPorId(Long id) {
        return emprestimoMapper.toDto(
                emprestimoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado")));
    }

    public List<EmprestimoDTO> listarTodosEmprestimos() {
        return emprestimoRepository.findAll().stream()
                .map(emprestimoMapper::toDto)
                .collect(Collectors.toList());
    }
}
