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

    @Column(name = "ID_PRODUTO", nullable = false)
    private int idProduto;

    @Column(name = "ID_PEDIDO", nullable = false)
    private int idPedido;

    @Column(name = "VALOR_PEDIDO", nullable = false)
    private Double valorPedido;
}