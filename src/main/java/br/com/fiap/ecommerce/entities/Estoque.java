package br.com.fiap.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Set<Setor> setores = new HashSet<>();
    private Lojista responsavel;
    @NotNull
    private Double pesoTotal;
    @NotNull
    private Double valorTotal;
}
