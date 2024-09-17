package com.aplication.pedidodelivery.repository;

import com.aplication.pedidodelivery.entities.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
