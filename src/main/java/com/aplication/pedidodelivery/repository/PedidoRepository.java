package com.aplication.pedidodelivery.repository;

import com.aplication.pedidodelivery.entities.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
