package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Table(name = "ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTOQUE")
    private Long id;

    @Column(name = "NOME_SETOR", nullable = false, length = 80)
    private String nomeSetor;

    @Column(name = "PRODUTOS")
    @OneToMany(mappedBy = "estoque")
    private Set<Produto> produtos = new HashSet<>();
}