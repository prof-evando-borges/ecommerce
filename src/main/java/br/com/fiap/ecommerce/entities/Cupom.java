package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.models.TipoDescontoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CUPOM")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O código do cupom é obrigatório")
    @Size(min = 3, max = 30, message = "O código deve ter entre 3 e 30 caracteres")
    @Column(name = "CODIGO", nullable = false, length = 30, unique = true)
    private String codigo;

    @NotNull(message = "O tipo de desconto é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_DESCONTO", nullable = false, length = 20)
    private TipoDescontoEnum tipoDesconto;

    @NotNull(message = "O valor do desconto é obrigatório")
    @DecimalMin(value = "0.01", message = "O desconto deve ser maior que zero")
    @DecimalMax(value = "9999.99", message = "O desconto máximo é R$ 9999,99 ou 100%")
    @Column(name = "VALOR_DESCONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDesconto;

    @NotNull(message = "A data de validade é obrigatória")
    @Future(message = "A data de validade deve ser uma data futura")
    @Column(name = "DATA_VALIDADE", nullable = false)
    private LocalDate dataValidade;

    @NotNull(message = "A quantidade máxima de usos é obrigatória")
    @Min(value = 1, message = "A quantidade máxima deve ser ao menos 1")
    @Column(name = "QUANTIDADE_MAXIMA", nullable = false)
    private Integer quantidadeMaxima;

    @Column(name = "QUANTIDADE_UTILIZADA", nullable = false)
    private Integer quantidadeUtilizada = 0;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo = true;

    @CreatedDate
    @Column(name = "DATA_CRIACAO", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "DATA_ATUALIZACAO", nullable = false)
    private LocalDateTime dataAtualizacao;
}