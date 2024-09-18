package com.aplication.pedidodelivery.services;


import com.aplication.pedidodelivery.dto.UsuarioDTO;
import com.aplication.pedidodelivery.entities.UsuarioModel;
import com.aplication.pedidodelivery.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
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

    // LISTAR TODOS OS USUARIOS
    @Transactional
    public List<UsuarioModel> listarTodos(){
        return usuarioRepository.findAll();
    }

    // BUSCAR POR ID
    @Transactional
    public Optional<UsuarioModel> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    @Transactional
    // CRIAR OU ATUALIZAR O USUARIO
    public UsuarioModel salvar(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setSenha(usuarioDTO.senha());
        usuario.setEndereco(usuarioDTO.endereco());
        usuario.setTelefone(usuarioDTO.telefone());
        return usuarioRepository.save(usuario);
    }
    // ATUALIZAR USUARIO EXISTENTE
    @Transactional
    public UsuarioModel atualizar(Long id, UsuarioDTO usuarioDTO){
        // Buscar usuario existente
        UsuarioModel usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID" + id));

        // Atualizar os campos do usuario existente com os dados do DTO
        usuarioExistente.setNome(usuarioDTO.nome());
        usuarioExistente.setEmail(usuarioDTO.email());
        usuarioExistente.setSenha(usuarioDTO.senha());
        usuarioExistente.setEndereco(usuarioDTO.endereco());

        // Salvar as alterações no banco
        return usuarioRepository.save(usuarioExistente);
    }

    // DELETAR USUARIO
    @Transactional
    public void deletar(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new EntityNotFoundException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    // BUSCAR UM USUARIO POR EMAIL
    @Transactional
    public UsuarioModel buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
