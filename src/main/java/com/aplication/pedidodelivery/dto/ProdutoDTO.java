package com.aplication.pedidodelivery.dto;

import java.util.Date;

public record ProdutoDTO(String nome,
                         String descricaoProduto,
                         Double precoProduto,
                         Date dataCadastro) {
}
