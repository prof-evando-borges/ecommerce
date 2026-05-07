package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_PAGAMENTO", updatable = false, nullable = false, length = 36)
    private String id;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.1", message = "O valor deve ser maior que zero")
    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @NotBlank(message = "O status do pagamento é obrigatório")
    @Column(name = "STATUS_PAGAMENTO", nullable = false, length = 50)
    private String statusPagamento;

    @NotNull(message = "A data de criação deve ser válida")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", updatable = false)
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "ID_CARTAO", nullable = false)
    private Cartao cartao;

}