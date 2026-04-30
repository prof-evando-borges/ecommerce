package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.models.StatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "Entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTREGA", nullable = false)
    private Long id;

    @Column(name = "STATUS", nullable = false)
    private StatusEnum status;

    @Column(name = "VALOR_FRETE", nullable = false)
    private Double valorFrete;

    @Column(name = "PRAZO_DIAS", nullable = false)
    private int prazoDias;

    @Column(name = "ID_PEDIDO", nullable = false)
    private int pedidoId;

    @Column(name = "ID_TRANSPORTADORA", nullable = false)
    private int transportadoraId;

    public Entrega(){}

    public Entrega(StatusEnum status, Double valorFrete, int prazoDias, int pedidoId, int transportadoraId) {
        this.status = status;
        this.valorFrete = valorFrete;
        this.prazoDias = prazoDias;
        this.pedidoId = pedidoId;
        this.transportadoraId = transportadoraId;
    }

    public Long getId() {
        return id;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(int transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

}
