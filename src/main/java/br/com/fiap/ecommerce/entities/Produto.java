package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @NotBlank(message = "O nome do produto é obrigatório!")
    @Size(max=150, message = "O nome deve ter no máximo 150 caracteres!")
    @Column(name = "NOME_PRODUTO", nullable = false, length = 150)
    private String nomeProduto;

    @Column(name = "DESCRICAO_PRODUTO", columnDefinition = "TEXT")
    private String descricaoProduto;

    @NotNull(message = "O preço do produto deve ser informado!")
    @DecimalMin(value = "0.1", message =  "O preço deve ser maior que zero!")
    @Column(name = "PRECO", nullable = false)
    private Double preco;

    @NotNull(message = "O status ativo deve ser definido!")
    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    @PositiveOrZero(message = "O peso não pode ser negativo!")
    @Column(name = "PESO")
    private Double peso;

    @PositiveOrZero(message = "A altura não pode ser negativa!")
    @Column(name = "ALTURA")
    private Double altura;

    @PositiveOrZero(message = "A largura não pode ser negativa!")
    @Column(name = "LARGURA")
    private Double largura;

    @PositiveOrZero(message = "A profundidade não pode ser negativa!")
    @Column(name = "PROFUNDIDADE")
    private Double profundidade;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ID_UNIDADE_MEDIDA_PESO")
    private UnidadeMedidaPeso unidadeMedidaPeso;

    @ManyToOne
    @JoinColumn(name = "ID_UNIDADE_MEDIDA_TAMANHO")
    private UnidadeMedidaTamanho unidadeMedidaTamanho;
}