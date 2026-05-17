package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.models.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TB_ENTREGA")
@Data
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotNull(message = "O status deve ser informado")
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @NotNull(message = "O valor do frete deve ser informado")
    @Min(value = 1, message = "O valor do frete deve ser ao menos R$1")
    @Column(name = "VALOR_FRETE", nullable = false)
    private Double valorFrete;

    @NotNull(message = "O prazo deve ser informado")
    @Min(value = 1, message = "O prazo de dias deve ser ao menos 1 dia")
    @Column(name = "PRAZO_DIAS", nullable = false)
    private Integer prazoDias;

    @NotNull(message = "O pedido é obrigatório")
    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", nullable = false)
    private Pedido pedido;

    @NotNull(message = "A transportadora é obrigatória")
    @ManyToOne
    @JoinColumn(name = "ID_TRANSPORTADORA", nullable = false)
    private Transportadora transportadora;

    public Entrega() {}

    public Entrega(StatusEnum status, Double valorFrete, Integer prazoDias, Pedido pedido, Transportadora transportadora) {
        this.status = status;
        this.valorFrete = valorFrete;
        this.prazoDias = prazoDias;
        this.pedido = pedido;
        this.transportadora = transportadora;
    }
}
