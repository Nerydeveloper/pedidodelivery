package com.aplication.pedidodelivery.models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_itemProduto")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoItem;

    @Column(name="valorItem")
    private double valorItem;

    @Column(name="quantidadeItem")
    private int quantidadeItem;

    @ManyToOne
    @JoinColumn(name="codPedido")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name="codProduto")
    private ProdutoModel produto;

    public Long getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Long codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public PedidoModel getPedido() {
        return pedido;
    }

    public void setPedido(PedidoModel pedido) {
        this.pedido = pedido;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}