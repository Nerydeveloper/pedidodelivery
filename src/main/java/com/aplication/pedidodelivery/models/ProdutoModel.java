package com.aplication.pedidodelivery.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_produto")
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

    public ProdutoModel() {}

    public ProdutoModel(Long codigoProduto, String nomeProduto, String descricaoProduto, Double precoProduto, Date dataCadastro) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.dataCadastro = dataCadastro;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}