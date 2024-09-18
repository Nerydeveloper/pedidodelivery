package com.aplication.pedidodelivery.repository;

import com.aplication.pedidodelivery.entities.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNomeProduto(String nomeProduto);
}
