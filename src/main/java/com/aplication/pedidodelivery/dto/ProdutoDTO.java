package com.aplication.pedidodelivery.dto;

import java.util.Date;

public record ProdutoDTO(String nomeProduto,
                         String descricaoProduto,
                         Double precoProduto,
                         Date dataCadastro) {
}
