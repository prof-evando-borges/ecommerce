package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private String titulo;
    private String descricao;
    private String status;
    private String prioridade;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}