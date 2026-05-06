package br.com.fiap.ecommerce.model;
 
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
 
@Entity[cite: 2]
@Table(name = "CUPOM")[cite: 2]
public class Cupom {
 
    @Id[cite: 2]
    @GeneratedValue(strategy = GenerationType.IDENTITY)[cite: 2]
    @Column(name = "ID_CUPOM")[cite: 2]
    private Long id;
 
    @NotBlank(message = "O código do cupom é obrigatório")[cite: 2]
    @Size(max = 50, message = "O código deve ter no máximo 50 caracteres")[cite: 2]
    @Column(name = "CODIGO", nullable = false, length = 50)[cite: 2]
    private String codigo;
 
    @NotNull(message = "O desconto deve ser informado")[cite: 2]
    @DecimalMin(value = "0.1", message = "O desconto deve ser maior que zero")[cite: 2]
    @Column(name = "DESCONTO", nullable = false)[cite: 2]
    private BigDecimal desconto;
 
    @NotNull(message = "A quantidade deve ser informada")[cite: 2]
    @Min(value = 1, message = "A quantidade deve ser ao menos 1 unidade")[cite: 2]
    @Column(name = "QUANTIDADE", nullable = false)[cite: 2]
    private Integer quantidade;
 
    @NotNull(message = "A data de criação deve ser válida")[cite: 2]
    @Temporal(TemporalType.TIMESTAMP)[cite: 2]
    @Column(name = "DATA_CRIACAO", updatable = false)[cite: 2]
    private Date dataCriacao;
 
}