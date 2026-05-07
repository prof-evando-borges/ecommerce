package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento {

    // 1º Atributo: ID como UUID (VARCHAR2 no banco)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_PAGAMENTO", updatable = false, nullable = false, length = 36)
    private String id;

    // 2º Atributo
    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.1", message = "O valor deve ser maior que zero")
    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    // 3º Atributo
    @NotBlank(message = "O status do pagamento é obrigatório")
    @Column(name = "STATUS_PAGAMENTO", nullable = false, length = 50)
    private String statusPagamento;

    // 4º Atributo
    @NotNull(message = "A data de criação deve ser válida")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO", updatable = false)
    private Date dataCriacao;

    // 5º Atributo: Relacionamento (Foreign Key que o professor desenhou)
    @ManyToOne
    @JoinColumn(name = "ID_CARTAO", nullable = false)
    private Cartao cartao;

    // Lembre-se de gerar os Getters e Setters
}