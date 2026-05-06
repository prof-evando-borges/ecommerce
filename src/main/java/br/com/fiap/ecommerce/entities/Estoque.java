package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "SETORES")
    private Set<Setor> setores = new HashSet<>();
    @Column(name = "RESPONSAVEL")
    private Lojista responsavel;
    @NotNull
    @Column(name = "PESO_TOTAL")
    private Double pesoTotal;
    @NotNull
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
}
