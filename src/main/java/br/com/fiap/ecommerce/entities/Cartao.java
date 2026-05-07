package br.com.fiap.ecommerce.entities;

public class Cartao {
    private String id;
    private String numeroMascarado;
    private String titular;

    public Cartao(String id, String numeroMascarado, String titular) {
        this.id = id;
        this.numeroMascarado = numeroMascarado;
        this.titular = titular;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNumeroMascarado() { return numeroMascarado; }
    public void setNumeroMascarado(String numeroMascarado) { this.numeroMascarado = numeroMascarado; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
}