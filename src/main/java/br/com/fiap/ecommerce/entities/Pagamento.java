package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.models.MetodoPagamentoEnum;
import br.com.fiap.ecommerce.models.StatusPagamentoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PAGAMENTO")
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O cliente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_CARTAO")
    private Cartao cartao;

    @ManyToOne
    @JoinColumn(name = "ID_CUPOM")
    private Cupom cupom;

    @NotNull(message = "O método de pagamento é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "METODO_PAGAMENTO", nullable = false, length = 30)
    private MetodoPagamentoEnum metodoPagamento;

    @NotNull(message = "O valor original é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor original deve ser maior que zero")
    @Column(name = "VALOR_ORIGINAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorOriginal;

    @Column(name = "VALOR_DESCONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDesconto = BigDecimal.ZERO;

    @Column(name = "VALOR_FINAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;

    @NotNull(message = "O status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    private StatusPagamentoEnum status;

    @Column(name = "DATA_PAGAMENTO", updatable = false)
    private LocalDateTime dataPagamento;

    @PrePersist
    public void prePersist() {
        dataPagamento = LocalDateTime.now();
        if (status == null) {
            status = StatusPagamentoEnum.PENDENTE;
        }
        if (valorDesconto == null) {
            valorDesconto = BigDecimal.ZERO;
        }
    }
}