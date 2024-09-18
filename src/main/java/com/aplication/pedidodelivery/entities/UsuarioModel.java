package com.aplication.pedidodelivery.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity // Indica que a classe é uma entidade JPA
@Table(name = "tb_usuarios")
@Data // é uma combinação de várias anotações do Lombok que juntas geram automaticamente métodos comuns para classes Java.
@NoArgsConstructor // faz com que o Lombok gere um construtor sem argumentos (padrão) para a classe.
@AllArgsConstructor //  faz com que o Lombok gere um construtor com argumentos que correspondem a todos os campos da classe
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome" , nullable = false)
    private String nome;

    @Column(name = "email" ,nullable = false, unique = true)
    private String email;

    @Column(name = "senha" ,nullable = false)
    private String senha;

    @Column(name = "endereco" ,nullable = false)
    private String endereco;

    @Column(name = "telefone" ,nullable = true)
    private String telefone;

    // Relacionamento com a entidade PedidoModel ( OneToMany )
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoModel> pedidos;


}
