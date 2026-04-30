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
    @Column(name = "ID_PEDIDO")
    private Long id;

    @Column(name = "USUARIO_ID", nullable = false)
    private int usuarioId;

    @Column(name = "NUMERO_PEDIDO", nullable = false)
    private int numeroPedido;
}