package com.aplication.pedidodelivery.controllers;

import com.aplication.pedidodelivery.dto.ItemPedidoDTO;
import com.aplication.pedidodelivery.entities.ItemPedidoModel;
import com.aplication.pedidodelivery.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/delivery/itens-pedido/")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoService iPedidoService) {
        this.itemPedidoService = iPedidoService;
    }



    // LISTAR TODOS OS ITENS DE PEDIDO
    @GetMapping
    public ResponseEntity<List<ItemPedidoModel>> listarItemPedidos() {
        List<ItemPedidoModel> itensPedidos = itemPedidoService.listarItemPedidos();
        return ResponseEntity.ok(itensPedidos);
    }

    // Cadastrar novo item de pedido
    @PostMapping("cadastrar")
    public ResponseEntity<ItemPedidoModel> cadastrarItem(@RequestBody ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoModel novoItem = itemPedidoService.cadastrarItemPedido(itemPedidoDTO);
        return ResponseEntity.status(201).body(novoItem);
    }


    @GetMapping("buscar/{codigoItem}")
    public ResponseEntity<ItemPedidoModel> buscarItemPedidoPorId(Long codigoItem) {
        try {
            ItemPedidoModel item = itemPedidoService.buscarItemPorId(codigoItem);
            return ResponseEntity.status(HttpStatus.OK).body(item);
        } catch ( Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Atualizar itemPedido
    @PutMapping("atualizar/{codigoItem}")
    public ResponseEntity<ItemPedidoModel> atualizarItemPedido(@PathVariable Long codigoItem, @RequestBody ItemPedidoDTO itemPedidoDTO) {
        try {
            ItemPedidoModel itemAtualizado = itemPedidoService.atualizarItemPedido(codigoItem, itemPedidoDTO);
            return ResponseEntity.status(HttpStatus.OK).body(itemAtualizado);
        } catch ( Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("deletar/{codigoItem}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable Long codigoItem) {
        try {
            itemPedidoService.excluirItemPedido(codigoItem);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch ( Exception e ){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
