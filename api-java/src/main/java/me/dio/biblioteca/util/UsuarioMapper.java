package me.dio.biblioteca.mapper;

import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .build();
    }

    public UsuarioDTO toDto(Usuario usuario) {
        return new UsuarioDTO(usuario.getNome(), usuario.getCpf());
    }
}
