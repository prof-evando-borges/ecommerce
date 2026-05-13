package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TB_UNIDADE_MEDIDA_PESO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeMedidaPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O nome da unidade de medida de peso é obrigatório!")
    @Size(max=50, message = "O nome deve ter no máximo 50 caracteres!")
    @Column(name = "UNIDADE_MEDIDA_PESO", nullable = false, length = 50)
    private String unidadeMedidaPeso;
}