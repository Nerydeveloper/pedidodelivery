package com.aplication.pedidodelivery.dto;

public record ItemPedidoDTO(Double valorItem,
                            Integer quantidadeItem,
                            Long codPedido,
                            Long codProduto
                             ) {
}
