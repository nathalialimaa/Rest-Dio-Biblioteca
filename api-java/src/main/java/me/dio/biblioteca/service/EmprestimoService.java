package me.dio.biblioteca.service;

import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmprestimoService {
        
    EmprestimoServiceImpl(EmprestimoRepository emprestimoRepository, EmprestimoMapper emprestimoMapper);

    Emprestimo salvarEmprestimo(EmprestimoDTO emprestimoRequest);

    EmprestimoDTO buscarEmprestimoPorId(Long id);

    List<EmprestimoDTO> listarTodosEmprestimos();
    
}