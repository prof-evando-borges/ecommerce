package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_UNIDADE_MEDIDA_PESO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    @Column(name = "UNIDADE_MEDIDA_PESO", nullable = false, length = 50)
    private String unidadeMedidaPeso;
}