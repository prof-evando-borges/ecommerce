package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_SETOR")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "NOME", length = 255)
    @NotNull(message = "O nome do Setor não pode ser NULO")
    private String nome;
    @Column(name = "NUMEROS_CORREDOR")
    @DecimalMin(value = "0.1", message = "O numero de corredores não pode ser menor que 0")
    private Integer numerosCorredor;
    @Column(name ="PRATELEIRA")
    @DecimalMin(value = "0.1", message = "O numero de prateleiras não pode ser menor que 0")
    private Integer prateleira;
}