package me.dio.biblioteca.repository;
import java.util.List; 

import me.dio.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
