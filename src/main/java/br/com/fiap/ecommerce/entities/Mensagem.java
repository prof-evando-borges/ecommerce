package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_MENSAGEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O ticket é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_TICKET", nullable = false)
    private Ticket ticket;

    @NotBlank(message = "O conteúdo é obrigatório")
    @Size(max = 1000, message = "O conteúdo deve ter no máximo 1000 caracteres")
    @Column(name = "CONTEUDO", nullable = false, length = 1000)
    private String conteudo;

    @NotBlank(message = "O autor é obrigatório")
    @Size(max = 100, message = "O autor deve ter no máximo 100 caracteres")
    @Column(name = "AUTOR", nullable = false, length = 100)
    private String autor;

    @Column(name = "DATA_ENVIO", updatable = false)
    private LocalDateTime dataEnvio;

    @PrePersist
    public void prePersist() {
        dataEnvio = LocalDateTime.now();
    }
}