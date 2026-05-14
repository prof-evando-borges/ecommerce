package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CATEGORIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O nome da categoria é obrigatório!")
    @Size(max=100, message = "O nome deve ter no máximo 100 caracteres!")
    @Column(name = "NOME_CATEGORIA", nullable = false, length = 100)
    private String nomeCategoria;
}