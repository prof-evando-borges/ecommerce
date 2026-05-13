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

    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "ID_PRODUTO", nullable = false)
    private String idProduto;

    @Column(name = "ID_PEDIDO", nullable = false)
    private String idPedido;

    @Column(name = "VALOR_ITEM", nullable = false)
    private Double valorItem;

    @Column(name = "QUANTIDADE", nullable = false)
    private int quantidade;
}