package me.dio.biblioteca.repository;

import me.dio.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);
    
    boolean existsByCpf(String cpf);
    
    Optional<Usuario> findByEmail(String email);
}