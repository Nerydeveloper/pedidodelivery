package com.aplication.pedidodelivery.controllers;

import com.aplication.pedidodelivery.dto.ProdutoDTO;
import com.aplication.pedidodelivery.entities.ProdutoModel;
import com.aplication.pedidodelivery.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/delivery/produtos/")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    // LISTAR TODOS OS PRODUTOS
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<ProdutoModel> produtos = produtoService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    // CRIAR PRODUTO
    @PostMapping("cadastrar")
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(produtoDTO));
    }

    // ATUALIZAR PRODUTO
    @PutMapping("atualizar/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        ProdutoModel produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
    }

    // DELETAR PRODUTO
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        // Tratamento de exeções
        try {
            produtoService.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }


}
