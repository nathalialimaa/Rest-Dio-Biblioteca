package me.dio.biblioteca.repository;

import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.enums.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    boolean existsByLivroAndStatus(Livro livro, StatusEmprestimo status);
    List<Emprestimo> findByStatus(StatusEmprestimo status);
    List<Emprestimo> findByUsuarioId(Long usuarioId);
}