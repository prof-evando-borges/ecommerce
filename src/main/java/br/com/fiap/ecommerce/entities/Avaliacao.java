package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(
        name = "TB_AVALIACAO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"ID_CLIENTE", "ID_PRODUTO"}
        )
)
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_LOJISTA", nullable = false)
    private Lojista lojista;

    @Min(value = 1, message = "A nota do produto deve ser no mínimo 1")
    @Max(value = 5, message = "A nota do produto deve ser no máximo 5")
    @Column(name = "NOTA_PRODUTO", nullable = false)
    private Integer notaProduto;

    @Min(value = 1, message = "A nota da loja deve ser no mínimo 1")
    @Max(value = 5, message = "A nota da loja deve ser no máximo 5")
    @Column(name = "NOTA_LOJA", nullable = false)
    private Integer notaLoja;
}