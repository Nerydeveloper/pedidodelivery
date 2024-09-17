package com.aplication.pedidodelivery.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pedidos")
@NoArgsConstructor
@AllArgsConstructor
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoPedido;

    @ManyToOne
    @JoinColumn(name="codigoUsuario")
    private UsuarioModel usuario;

    @Column(name="valorPedido")
    private Double valorPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dataPedido")
    private Date dataPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedidoModel> itens;

}
