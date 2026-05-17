package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_TRANSPORTADORA")
@Data
public class Transportadora {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O nome deve ser preenchido")
    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @NotNull(message = "O peso mínimo deve ser informado")
    @DecimalMin(value = "0.1", message = "O peso mínimo deve ser ao menos 0.1kg")
    @Column(name = "PESO_MIN", nullable = false)
    private Double pesoMin;

    @NotNull(message = "O peso máximo deve ser informado")
    @Max(value = 150, message = "O peso máximo deve ser no máximo 150kg")
    @Column(name = "PESO_MAX", nullable = false)
    private Double pesoMax;

    @NotNull(message = "O valor base deve ser informado")
    @Column(name = "VALOR_BASE", nullable = false)
    private Double valorBase;

    @NotNull(message = "O prazo deve ser informado")
    @Min(value = 1, message = "O prazo de dias deve ser ao menos 1 dia")
    @Column(name = "PRAZO_DIAS", nullable = false)
    private Integer prazoDias;

    public Transportadora() {}

    public Transportadora(String nome, Double pesoMin, Double pesoMax, Double valorBase, Integer prazoDias) {
        this.nome = nome;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.valorBase = valorBase;
        this.prazoDias = prazoDias;
    }
}
