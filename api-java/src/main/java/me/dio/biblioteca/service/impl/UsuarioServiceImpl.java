package me.dio.biblioteca.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.biblioteca.dto.UsuarioDTO;
import me.dio.biblioteca.entity.Usuario;
import me.dio.biblioteca.exception.UsuarioNotFoundException;
import me.dio.biblioteca.repository.UsuarioRepository;
import me.dio.biblioteca.service.UsuarioService;
import me.dio.biblioteca.util.UsuarioMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario salvarUsuario(UsuarioDTO usuarioDTO) {
        if(usuarioRepository.existsByCpf(usuarioDTO.cpf())) {
            throw new IllegalArgumentException("Usuário já cadastrado com este CPF");
        }
        
        if(usuarioRepository.existsByEmail(usuarioDTO.email())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        return usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
    }

    @Override
    public UsuarioDTO buscarPorCpf(String cpf) {
        return usuarioMapper.toDto(
            usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new UsuarioNotFoundException(cpf, "CPF"))
        );
    }

    @Override
    public Usuario buscarOuCriarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.findByCpf(usuarioDTO.cpf())
            .orElseGet(() -> usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO)));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new UsuarioNotFoundException(id));
    }
}