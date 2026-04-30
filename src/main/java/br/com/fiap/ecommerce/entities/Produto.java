package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(nullable = false)
    private String nomeProduto;

    @Column(columnDefinition = "TEXT")
    private String descricaoProduto;

    private Double preco;
    private Boolean ativo;
    private Double peso;
    private Double altura;
    private Double largura;
    private Double profundidade;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_unidade_medida_peso")
    private UnidadeMedidaPeso unidadeMedidaPeso;

    @ManyToOne
    @JoinColumn(name = "id_unidade_medida_tamanho")
    private UnidadeMedidaTamanho unidadeMedidaTamanho;
}