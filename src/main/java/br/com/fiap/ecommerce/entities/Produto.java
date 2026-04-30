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
    @Column(name = "ID_PRODUTO")
    private Long idProduto;

    @Column(name = "NOME_PRODUTO", nullable = false, length = 150)
    private String nomeProduto;

    @Column(name = "DESCRICAO_PRODUTO", columnDefinition = "TEXT")
    private String descricaoProduto;

    @Column(name = "PRECO", nullable = false)
    private Double preco;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "LARGURA")
    private Double largura;

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
    @JoinColumn(name = "UNIDADE_MEDIDA_TAMANHO")
    private UnidadeMedidaTamanho unidadeMedidaTamanho;
}