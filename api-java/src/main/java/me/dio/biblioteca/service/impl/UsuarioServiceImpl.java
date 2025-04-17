package me.dio.biblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;
import me.dio.biblioteca.repository.UsuarioRepository;
import me.dio.biblioteca.service.UsuarioService;
import me.dio.biblioteca.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario saveUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsByCpf(usuarioDTO.cpf())) {
            throw new IllegalArgumentException("Usuário já cadastrado.");
        }

        return usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
    }

    @Override
    public UsuarioDTO find(String cpf) {
        return usuarioMapper.toDto(
                usuarioRepository.findByCpf(cpf)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado.")));
    }

    @Override
    public Usuario findOrCreateUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.findByCpf(usuarioDTO.cpf())
                .orElseGet(() -> usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
    }
}
