package br.com.fiap.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(
        name = "AVALIACAO",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"ID_CLIENTE", "ID_PRODUTO"}
        )
)
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_LOJISTA", nullable = false)
    private Lojista loja;

    @Min(value = 1, message = "A nota do produto deve ser no mínimo 1")
    @Max(value = 5, message = "A nota do produto deve ser no máximo 5")
    @Column(nullable = false)
    private Integer notaProduto;

    @Min(value = 1, message = "A nota da loja deve ser no mínimo 1")
    @Max(value = 5, message = "A nota da loja deve ser no máximo 5")
    @Column(nullable = false)
    private Integer notaLoja;

    public Avaliacao() {
    }

    public Avaliacao(
            Produto produto,
            Cliente cliente,
            Lojista loja,
            Integer notaProduto,
            Integer notaLoja
    ) {
        this.produto = produto;
        this.cliente = cliente;
        this.loja = loja;
        this.notaProduto = notaProduto;
        this.notaLoja = notaLoja;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Lojista getLoja() {
        return loja;
    }

    public Integer getNotaProduto() {
        return notaProduto;
    }

    public Integer getNotaLoja() {
        return notaLoja;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLoja(Lojista loja) {
        this.loja = loja;
    }

    public void setNotaProduto(Integer notaProduto) {
        this.notaProduto = notaProduto;
    }

    public void setNotaLoja(Integer notaLoja) {
        this.notaLoja = notaLoja;
    }
}