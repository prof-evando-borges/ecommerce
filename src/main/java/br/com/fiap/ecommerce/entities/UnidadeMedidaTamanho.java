package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_unidade_medida_tamanho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaTamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer unidadeMedidaTamanhoId;

    @Column(nullable = false)
    private String unidadeMedidaTamanho;
}