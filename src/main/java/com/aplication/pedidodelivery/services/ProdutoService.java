package com.aplication.pedidodelivery.services;

import com.aplication.pedidodelivery.dto.ProdutoDTO;
import com.aplication.pedidodelivery.entities.ProdutoModel;
import com.aplication.pedidodelivery.entities.UsuarioModel;
import com.aplication.pedidodelivery.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // LISTAR TODOS OS PROODUTOS
    @Transactional
    public List<ProdutoModel> listarTodos(){
        return produtoRepository.findAll();
    }

    // BUSCAR PRODUTO POR ID
    @Transactional
    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    //CRIAR NOVO PRODUTO SEM ID
    @Transactional
    public ProdutoModel criarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNomeProduto(produtoDTO.nomeProduto());
        produto.setDescricaoProduto(produtoDTO.descricaoProduto());
        produto.setPrecoProduto(produtoDTO.precoProduto());
        produto.setDataCadastro(produtoDTO.dataCadastro());

        return produtoRepository.save(produto);
    }

    // ATUALIZAR PRODUTO EXISTENTE
    @Transactional
    public ProdutoModel atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<ProdutoModel> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutoModel produto = produtoExistente.get();
            produto.setNomeProduto(produtoDTO.nomeProduto());
            produto.setDescricaoProduto(produtoDTO.descricaoProduto());
            produto.setPrecoProduto(produtoDTO.precoProduto());
            produto.setDataCadastro(produtoDTO.dataCadastro());

            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto com ID " + id + " não encontrado");
        }
    }





    // EXCLUIR PRODUTO
    @Transactional
    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }

}
