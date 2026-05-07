package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;
    @Column(name = "NUMERO_CORREDOR")
    private Integer numeroCorredor;
    @Column(name ="PRATELEIRA")
    private Integer prateleiras;
    @Column(name = "PRODUTOS")
    private Set<Produto> produtos = new HashSet<>();
}