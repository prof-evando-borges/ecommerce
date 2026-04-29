package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_unidade_medida_peso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidadeMedidaPeso;

    @Column(nullable = false)
    private String unidadeMedidaPeso;
}