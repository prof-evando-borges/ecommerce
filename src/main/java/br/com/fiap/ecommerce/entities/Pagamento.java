package br.com.fiap.ecommerce.entities;

import java.math.BigDecimal;

public class Pagamento {
    private String id;
    private String metodo;
    private BigDecimal valor;
    private String status;

    public Pagamento(String id, String metodo, BigDecimal valor, String status) {
        this.id = id;
        this.metodo = metodo;
        this.valor = valor;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}