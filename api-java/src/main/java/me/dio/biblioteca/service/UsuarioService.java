package me.dio.biblioteca.service;

import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;

public interface UsuarioService {

    Usuario saveUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO find(String cpf);
    Usuario findOrCreateUsuario(UsuarioDTO usuarioDTO);
}
