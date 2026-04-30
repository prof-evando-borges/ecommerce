package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MENSAGEM")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ticket", nullable = false)
    private Ticket ticket;

    @Column(name = "CONTEUDO", nullable = false, length = 1000)
    private String conteudo;

    @Column(name = "AUTOR", nullable = false, length = 100)
    private String autor;

    @Column(name = "DATA_ENVIO", updatable = false)
    private LocalDateTime dataEnvio;

    // Getters
    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public String getConteudo() { return conteudo; }
    public String getAutor() { return autor; }
    public LocalDateTime getDataEnvio() { return dataEnvio; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
}