package com.aplication.pedidodelivery.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="tb_pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPedido;

    @ManyToOne
    @JoinColumn(name="codigoUsuario")
    private UsuarioModel usuario; // Lembre de CRIAR A CLASSE UsuarioModel

    @Column(name="valorPedido")
    private Double valorPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dataPedido")
    private Date dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    public PedidoModel(){}

    public PedidoModel(Long codigoPedido, UsuarioModel usuario, Double valorPedido, Date dataPedido, List<ItemPedido> itens) {
        this.codigoPedido = codigoPedido;
        this.usuario = usuario;
        this.valorPedido = valorPedido;
        this.dataPedido = dataPedido;
        this.itens = itens;
    }

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}