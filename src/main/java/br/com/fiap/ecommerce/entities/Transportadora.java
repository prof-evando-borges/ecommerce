package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TRANSPORTADORA")
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSPORTADORA", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "PESO_MIN", nullable = false)
    private Double pesoMin;

    @Column(name = "PESO_MAX", nullable = false)
    private Double pesoMax;

    @Column(name = "VALOR_BASE", nullable = false)
    private Double valorBase;

    @Column(name = "PRAZO_DIAS", nullable = false)
    private int prazoDias;

    public Transportadora(){}

    public Transportadora(String nome, Double pesoMin, Double pesoMax, Double valorBase, int prazoDias) {
        this.nome = nome;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.valorBase = valorBase;
        this.prazoDias = prazoDias;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(Double pesoMin) {
        this.pesoMin = pesoMin;
    }

    public Double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(Double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }

}
