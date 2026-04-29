package br.com.fiap.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatusEnum status;
    private Double valorFrete;
    private int prazoDias;
    private int pedidoId;
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
