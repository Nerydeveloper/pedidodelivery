package com.aplication.pedidodelivery.controllers;

import com.aplication.pedidodelivery.entities.UsuarioModel;
import com.aplication.pedidodelivery.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplication.pedidodelivery.dto.UsuarioDTO;

@RestController
@RequestMapping(value = "/delivery/usuario/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }

    @PostMapping
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarOuAtualizar(usuarioDTO));
    }


}
