package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.UUID;

@Entity
@Table(name = "TB_CARTAO")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @NotBlank(message = "O nome do titular é obrigatório")
    @Size(max = 100, message = "O nome do titular deve ter no máximo 100 caracteres")
    @Column(name = "TITULAR", nullable = false, length = 100)
    private String titular;

    @NotBlank(message = "Os últimos quatro dígitos são obrigatórios")
    @Size(min = 4, max = 4, message = "Os últimos quatro dígitos devem conter exatamente 4 caracteres")
    @Pattern(regexp = "\\d{4}", message = "Os últimos quatro dígitos devem ser numéricos")
    @Column(name = "ULTIMOS_DIGITOS", nullable = false, length = 4)
    private String ultimosDigitos;

    @NotBlank(message = "A bandeira do cartão é obrigatória")
    @Size(max = 30, message = "A bandeira deve ter no máximo 30 caracteres")
    @Column(name = "BANDEIRA", nullable = false, length = 30)
    private String bandeira;

    @NotNull(message = "A validade do cartão é obrigatória")
    @Column(name = "VALIDADE", nullable = false)
    private YearMonth validade;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo = true;

    @CreatedDate
    @Column(name = "DATA_CRIACAO", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}