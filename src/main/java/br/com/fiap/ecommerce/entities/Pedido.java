package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PEDIDO")
@Getter
@Setter
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "ID_CLIENTE", nullable = false)
    private String idCliente;

    @Column(name = "NUMERO_PEDIDO", nullable = false)
    private number numeroPedido;

    @Column(name = "DATA_ENTREGA", nullable = false)
    private date dataEntrega;

    @Column(name = "VALOR_FINAL", nullable = false)
    private double valorFinal;
}