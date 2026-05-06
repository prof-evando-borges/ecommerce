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
    @Column(name = "ID_UNIDADE_MEDIDA_PESO")
    private Integer idUnidadeMedidaPeso;

    @Column(name = "UNIDADE_MEDIDA_PESO", nullable = false, length = 50)
    private String unidadeMedidaPeso;
}