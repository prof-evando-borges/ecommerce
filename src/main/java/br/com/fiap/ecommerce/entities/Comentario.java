package br.com.fiap.ecommerce.entities;

import br.com.fiap.ecommerce.entities.Avaliacao;
import jakarta.persistence.*;

@Entity
@Table(name = "COMENTARIOS")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String comentario;

    @OneToOne
    @JoinColumn(name = "AVALIACOES", nullable = false)
    private Avaliacao avaliacao;

    public Comentario() {}

    public Comentario(String comentario, Avaliacao avaliacao) {
        this.comentario = comentario;
        this.avaliacao = avaliacao;
    }

    // GETTERS E SETTERS

    public Long getId() { return id; }

    public String getComentario() { return comentario; }

    public Avaliacao getAvaliacao() { return avaliacao; }

    public void setId(Long id) { this.id = id; }

    public void setComentario(String comentario) { this.comentario = comentario; }

    public void setAvaliacao(Avaliacao avaliacao) { this.avaliacao = avaliacao; }
}
}