package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TICKET")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
    @Column(name = "DESCRICAO", length = 500)
    private String descricao;

    @NotBlank(message = "O status é obrigatório")
    @Size(max = 50, message = "O status deve ter no máximo 50 caracteres")
    @Column(name = "STATUS", nullable = false, length = 50)
    private String status;

    @NotBlank(message = "A prioridade é obrigatória")
    @Size(max = 50, message = "A prioridade deve ter no máximo 50 caracteres")
    @Column(name = "PRIORIDADE", nullable = false, length = 50)
    private String prioridade;

    @Column(name = "DATA_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
}