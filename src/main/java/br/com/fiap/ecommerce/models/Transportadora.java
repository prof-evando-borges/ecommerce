package br.com.fiap.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double pesoMin;
    private Double pesoMax;
    private Double valorBase;
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
