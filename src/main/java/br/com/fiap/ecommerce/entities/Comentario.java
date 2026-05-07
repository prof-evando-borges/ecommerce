package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "COMENTARIOS")
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @NotBlank(message = "O comentário é obrigatório")
    @Size(max = 500, message = "O comentário deve ter no máximo 500 caracteres")
    @Column(name = "COMENTARIO", nullable = false, length = 500)
    private String comentario;

    @OneToOne
    @JoinColumn(name = "ID_AVALIACAO", nullable = false)
    private Avaliacao avaliacao;
}