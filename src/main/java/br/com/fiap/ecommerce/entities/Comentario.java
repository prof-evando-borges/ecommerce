package br.com.fiap.ecommerce.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "COMENTARIOS")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String comentario;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}