package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_UNIDADE_MEDIDA_TAMANHO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaTamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "UNIDADE_MEDIDA_TAMANHO", nullable = false, length = 50)
    private String unidadeMedidaTamanho;
}