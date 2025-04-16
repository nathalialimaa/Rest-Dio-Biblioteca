package me.dio.biblioteca.repository;

import me.dio.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Optional<Livro> findByCodigoBarras(Integer codigoBarras);
}