package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "ITEMPEDIDO")
@Data
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O pedido é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", nullable = false)
    private Pedido pedido;

    @NotNull(message = "O produto é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @Positive(message = "O valor do item deve ser maior que zero")
    @Column(name = "VALOR_ITEM", nullable = false)
    private Double valorItem;

    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;
}
