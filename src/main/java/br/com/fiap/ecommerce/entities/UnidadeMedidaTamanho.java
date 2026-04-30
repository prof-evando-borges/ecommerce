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
    @Column(name = "ID_UNIDADE_MEDIDA_TAMANHO")
    private Integer unidadeMedidaTamanhoId;

    @Column(name = "UNIDADE_MEDIDA_TAMANHO", nullable = false, length = 50)
    private String unidadeMedidaTamanho;
}