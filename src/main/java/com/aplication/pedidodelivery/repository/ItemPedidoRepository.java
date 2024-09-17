package com.aplication.pedidodelivery.repository;

import com.aplication.pedidodelivery.entities.ItemPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {
}
