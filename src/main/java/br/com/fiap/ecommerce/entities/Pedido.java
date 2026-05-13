package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "PEDIDO")
@Getter
@Setter
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "CLIENTE", nullable = false)
    private String Cliente;

    @Column(name = "NUMERO_PEDIDO", nullable = false)
    private Number numeroPedido;

    @Column(name = "DATA_ENTREGA", nullable = false)
    private Data dataEntrega;

    @Column(name = "VALOR_FINAL", nullable = false)
    private double valorFinal;

    }
}