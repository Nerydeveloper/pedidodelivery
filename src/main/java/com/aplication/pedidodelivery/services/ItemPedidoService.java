package com.aplication.pedidodelivery.services;

import com.aplication.pedidodelivery.dto.ItemPedidoDTO;
import com.aplication.pedidodelivery.entities.ItemPedidoModel;
import com.aplication.pedidodelivery.entities.PedidoModel;
import com.aplication.pedidodelivery.entities.ProdutoModel;
import com.aplication.pedidodelivery.repository.ItemPedidoRepository;
import com.aplication.pedidodelivery.repository.PedidoRepository;
import com.aplication.pedidodelivery.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    // CADASTRAR
    @Transactional
    public ItemPedidoModel cadastrarItemPedido(ItemPedidoDTO itemPedidoDTO) {
        ProdutoModel produto = produtoRepository.findById(itemPedidoDTO.codProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        // Aqui, você precisará de um código de pedido, ou ajusta a lógica conforme a aplicação
        PedidoModel pedido = pedidoRepository.findById(itemPedidoDTO.codPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setProduto(produto);
        itemPedido.setQuantidadeItem(itemPedidoDTO.quantidadeItem());
        itemPedido.setValorItem(itemPedidoDTO.valorItem());
        itemPedido.setPedido(pedido);

        return itemPedidoRepository.save(itemPedido);
    }

    // LISTAR TODOS OS PEDIDOS
    @Transactional
    public List<ItemPedidoModel> listarItemPedidos() {
        return itemPedidoRepository.findAll();
    }

    // EXCLUIR
    @Transactional
    public void excluirItemPedido(Long id) {
        if (!itemPedidoRepository.existsById(id)) {

            throw new EntityNotFoundException("Item do pedido não encontrado");
        }
        itemPedidoRepository.deleteById(id);
    }

    // ATUALIZAR
    @Transactional
    public ItemPedidoModel atualizarItemPedido(Long id, ItemPedidoDTO itemPedidoDTO) {
        ItemPedidoModel itemPedido = itemPedidoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item do pedido não encontrado"));

        ProdutoModel produto = produtoRepository.findById(itemPedidoDTO.codProduto()).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        PedidoModel pedido = pedidoRepository.findById(itemPedidoDTO.codPedido()).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

        itemPedido.setProduto(produto);
        itemPedido.setQuantidadeItem(itemPedidoDTO.quantidadeItem());
        itemPedido.setValorItem(itemPedidoDTO.valorItem());
        itemPedido.setPedido(pedido);

        return itemPedidoRepository.save(itemPedido);
    }
    @Transactional
    public ItemPedidoModel buscarItemPorId(Long codigoItem) {
        return itemPedidoRepository.findById(codigoItem).orElseThrow(() -> new EntityNotFoundException("Item de pedido não encontrado"));
    }



}
