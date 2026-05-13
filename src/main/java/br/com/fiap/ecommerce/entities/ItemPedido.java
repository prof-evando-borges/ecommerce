package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
@Getter
@Setter
@Data
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "VALOR_ITEM", nullable = false)
    private Double valorItem;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;
}