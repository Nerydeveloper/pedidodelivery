package com.aplication.pedidodelivery.services;

import com.aplication.pedidodelivery.dto.ProdutoDTO;
import com.aplication.pedidodelivery.entities.ProdutoModel;
import com.aplication.pedidodelivery.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Transactional
    // LISTAR TODOS OS PROODUTOS
    public List<ProdutoModel> listarTodos(){
        return produtoRepository.findAll();
    }

    @Transactional
    // BUSCAR PRODUTO POR ID
    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }
    @Transactional
    //CRIAR OU ATUALIZAR PRODUTO
    public ProdutoModel salvarOuAtualizar(ProdutoDTO produtoDTO){
        ProdutoModel produto = new ProdutoModel();
        produto.setNomeProduto(produtoDTO.nome());
        produto.setDescricaoProduto(produtoDTO.descricaoProduto());
        produto.setPrecoProduto(produtoDTO.precoProduto());
        produto.setDataCadastro(produtoDTO.dataCadastro());

        return produtoRepository.save(produto);
    }
    // EXCLUIR PRODUTO
    @Transactional
    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }

}
