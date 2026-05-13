package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TB_PEDIDO")
@Getter
@Setter
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "NUMERO_PEDIDO", nullable = false)
    private Integer numeroPedido;

    @Column(name = "DATA_ENTREGA", nullable = false)
    private Data dataEntrega;

    @Column(name = "VALOR_FINAL", nullable = false)
    private Double valorFinal;
}
