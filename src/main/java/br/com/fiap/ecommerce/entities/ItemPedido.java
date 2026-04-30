package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ITEMPEDIDO")
@Getter
@Setter
@Data
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDPRODUTO", nullable = false)
    private int idProduto;

    @Column(name = "IDPEDIDO", nullable = false)
    private int idPedido;

    @Column(name = "VALORPEDIDO", nullable = false)
    private Double valorPedido;
}