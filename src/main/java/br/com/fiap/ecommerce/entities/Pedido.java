package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PEDIDO")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "NUMERO_PEDIDO", nullable = false)
    private Integer numeroPedido;

    @Column(name = "DATA_ENTREGA", nullable = false)
    private Date dataEntrega;

    @Positive(message = "O valor final deve ser maior que zero")
    @Column(name = "VALOR_FINAL", nullable = false)
    private Double valorFinal;
}
