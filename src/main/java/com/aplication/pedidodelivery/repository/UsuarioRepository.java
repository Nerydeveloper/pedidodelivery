package com.aplication.pedidodelivery.repository;

import com.aplication.pedidodelivery.entities.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    //Optional<UsuarioModel> findByEmail(String email) ;
    UsuarioModel findByEmail(String email);
}
