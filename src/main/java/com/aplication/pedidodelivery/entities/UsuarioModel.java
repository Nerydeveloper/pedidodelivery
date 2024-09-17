package com.aplication.pedidodelivery.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@Data // é uma combinação de várias anotações do Lombok que juntas geram automaticamente métodos comuns para classes Java.
@NoArgsConstructor // faz com que o Lombok gere um construtor sem argumentos (padrão) para a classe.
@AllArgsConstructor //  faz com que o Lombok gere um construtor com argumentos que correspondem a todos os campos da classe
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String telefone;

}
