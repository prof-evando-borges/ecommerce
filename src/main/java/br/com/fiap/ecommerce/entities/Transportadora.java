package br.com.fiap.ecommerce.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_TRANSPORTADORA")
@Data
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @NotBlank(message = "O nome deve ser preenchido")
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @NotNull(message = "O peso minimo deve ser informado")
    @DecimalMin(value = "0.1", message = "O peso do produto deve se ao menos 0.1kg")
    @Column(name = "PESO_MIN", nullable = false)
    private Double pesoMin;

    @NotNull(message = "O peso maximo deve ser informado")
    @Max(value = 150, message = "O peso do produto deve ser no maximo 150kg")
    @Column(name = "PESO_MAX", nullable = false)
    private Double pesoMax;

    @NotNull(message = "O Valor deve ser informado")
    @Column(name = "VALOR_BASE", nullable = false)
    private Double valorBase;

    @NotNull(message = "O prazo deve ser informado")
    @Min(value = 1, message = "O prazo de dias deve ser ao menos 1 dia")
    @Column(name = "PRAZO_DIAS", nullable = false)
    private int prazoDias;

    public Transportadora(){}

    public Transportadora(String nome, Double pesoMin, Double pesoMax, Double valorBase, int prazoDias) {
        this.nome = nome;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.valorBase = valorBase;
        this.prazoDias = prazoDias;
    }

}
