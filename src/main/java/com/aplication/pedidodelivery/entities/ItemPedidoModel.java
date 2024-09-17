package com.aplication.pedidodelivery.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_itemPedido")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoModel {
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
}
