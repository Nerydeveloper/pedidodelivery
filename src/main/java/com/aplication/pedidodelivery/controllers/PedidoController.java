package com.aplication.pedidodelivery.controllers;

import com.aplication.pedidodelivery.dto.PedidoDTO;
import com.aplication.pedidodelivery.entities.PedidoModel;
import com.aplication.pedidodelivery.services.PedidoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery/pedidos/")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // LISTAR TODOS OS PEDIDOS
    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarTodosPedidos(){
        List<PedidoModel> pedidos = pedidoService.listarPedidos();
        //return new ResponseEntity<>(pedidos, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }


    // CRIAR PEDIDO
    @PostMapping("cadastrar")
    public ResponseEntity<Void> create(@RequestBody PedidoDTO pedidoDTO) {
        try{
            pedidoService.cadastrarPedido(pedidoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    // BUSCAR PEDIDO PELO ID
    @GetMapping("{codigoPedido}")
    public ResponseEntity<PedidoModel> buscarPedidoPorId(@PathVariable Long  codigoPedido) {
        try {
            PedidoModel pedido = pedidoService.buscarPedidoPorId(codigoPedido);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ATUALIZAR PEDIDO
    @PutMapping("atualizar/{codigoPedido}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable Long codigoPedido, @RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoModel pedidoAtualizado = pedidoService.atualizarPedido(codigoPedido, pedidoDTO);
            //return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(pedidoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELETAR PEDIDO
    @DeleteMapping("deletar/{codigoPedido}")
    public ResponseEntity<Void> removerPedido(@PathVariable Long codigoPedido) {
        try {
            pedidoService.excluirPedido(codigoPedido);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
