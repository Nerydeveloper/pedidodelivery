package com.aplication.pedidodelivery.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tb_produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoProduto;

    @Column(name = "nomeProduto", nullable = false, length = 100)
    private String nomeProduto;

    @Column(name = "descricaoProduto", length = 255)
    private String descricaoProduto;

    @Column(name = "precoProduto", nullable = false)
    private Double precoProduto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataCadastro")
    private Date dataCadastro;
}
