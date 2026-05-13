package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@Table(name = "TB_ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @OneToMany
    private Set<Setor> setores = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "ID_RESPONSAVEL")
    @NotBlank(message = "o Id do Lojista não pode ser Nulo ou estar em Branco")
    private Lojista idLojista;
    @NotNull
    @Column(name = "PESO_TOTAL")
    @DecimalMin(value = "0.1", message = "O valor de PESO TOTAL não pode ser Nulo")
    private Double pesoTotal;
    @DecimalMin(value = "0.1", message = "O VALOR TOTAL não pode ser Nulo")
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
}
