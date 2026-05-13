package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.models.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name ="TB_ENTREGA")
@Data
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private UUID id;

    @NotBlank(message = "O status deve ser informado")
    @Column(name = "STATUS", nullable = false)
    private StatusEnum status;

    @NotNull(message = "O valor do frete deve ser informado")
    @Min(value = 1, message = "O valor do frete deve ser ao menos R$1")
    @Column(name = "VALOR_FRETE", nullable = false)
    private Double valorFrete;

    @NotNull(message = "O prazo deve ser informado")
    @Column(name = "PRAZO_DIAS", nullable = false)
    @Min(value = 1, message = "O prazo de dias deve ser ao menos 1 dia")
    private int prazoDias;

    @NotBlank(message = "O ID do pedido deve ser informado")
    @Column(name = "ID_PEDIDO", nullable = false)
    private int pedidoId;

    @NotBlank(message = "O ID da transportadora deve ser informado")
    @Column(name = "ID_TRANSPORTADORA", nullable = false)
    private UUID transportadoraId;

    public Entrega(){}

    public Entrega(StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, UUID transportadoraId) {
        this.status = status;
        this.valorFrete = valorFrete;
        this.prazoDias = prazoDias;
        this.pedidoId = pedidoId;
        this.transportadoraId = transportadoraId;
    }


}
