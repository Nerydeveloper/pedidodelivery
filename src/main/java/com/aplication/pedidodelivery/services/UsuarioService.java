package com.aplication.pedidodelivery.services;


import com.aplication.pedidodelivery.dto.UsuarioDTO;
import com.aplication.pedidodelivery.entities.UsuarioModel;
import com.aplication.pedidodelivery.repository.UsuarioRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    // Listar todos os usuarios
    public List<UsuarioModel> listarTodos(){
        return usuarioRepository.findAll();
    }
    @Transactional
    // Buscar um usuario por ID
    public Optional<UsuarioModel> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }
    @Transactional
    //  Criar ou atualizar um usuário
    public UsuarioModel salvarOuAtualizar(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(usuarioDTO.senha());
        usuario.setEndereco(usuarioDTO.endereco());
        return usuarioRepository.save(usuario);
    }
    @Transactional
    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }
    @Transactional
    // Buscar um usuario por email
    public UsuarioModel buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
