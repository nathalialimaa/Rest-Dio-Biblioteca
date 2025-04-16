package me.dio.biblioteca.service;

import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;

public interface UsuarioService {
    Usuario salvarUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO buscarPorCpf(String cpf);
    Usuario buscarOuCriarUsuario(UsuarioDTO usuarioDTO);
    Usuario buscarPorId(Long id);
}