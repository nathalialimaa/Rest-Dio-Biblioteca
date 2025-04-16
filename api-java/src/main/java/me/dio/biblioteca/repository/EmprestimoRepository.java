package me.dio.biblioteca.repository;
import me.dio.biblioteca.enums.StatusEmprestimo;
import me.dio.biblioteca.entity.Emprestimo;
import me.dio.biblioteca.entity.Livro;
import me.dio.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByUsuario(Usuario usuario);
    
    List<Emprestimo> findByLivro(Livro livro);
    
    List<Emprestimo> findByStatus(StatusEmprestimo status);
    
    boolean existsByLivroAndStatusNot(Livro livro, StatusEmprestimo status);
}