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
    private UUID id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(name = "numero_corredor", nullable = false)
    private Integer numeroCorredor;
    @Column(nullable = false)
    private Integer prateleiras;
    private Set<Produto> produtos = new HashSet<>();
}
