package com.aplication.pedidodelivery.controllers;

import com.aplication.pedidodelivery.entities.UsuarioModel;
import com.aplication.pedidodelivery.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aplication.pedidodelivery.dto.UsuarioDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/delivery/usuarios/")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }
    // LISTAR USUARIO
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    // CRIAR USUARIO
    @PostMapping("cadastrar/")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuarioDTO));
    }

    // ATUALIZAR USUARIO
    @PutMapping("atualizar/{id}/")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {

        UsuarioModel usuarioAtualizado = usuarioService.atualizar( id, usuarioDTO);
        return  ResponseEntity.status(HttpStatus.OK).body(usuarioAtualizado);
    }

    // EXCLUIR USUARIO
    @DeleteMapping("deletar/{id}/")
    public ResponseEntity<UsuarioModel> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
