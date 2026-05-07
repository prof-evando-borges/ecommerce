package br.com.fiap.ecommerce.entities;


import jakarta.persistence.*;

@Entity
@Table(
        name = "AVALIACAO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"cliente_id", "produto_id"})
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
    private Loja loja;

    @Column(nullable = false)
    private Integer notaProduto;

    @Column(nullable = false)
    private Integer notaLoja;

    public Avaliacao() {}

    public Avaliacao(Produto produto, Cliente cliente, Loja loja, Integer notaProduto, Integer notaLoja) {
        this.produto = produto;
        this.cliente = cliente;
        this.loja = loja;
        this.notaProduto = notaProduto;
        this.notaLoja = notaLoja;
    }

    // GETTERS E SETTERS

    public Long getId() { return id; }

    public Produto getProduto() { return produto; }

    public Cliente getCliente() { return cliente; }

    public Loja getLoja() { return loja; }

    public Integer getNotaProduto() { return notaProduto; }

    public Integer getNotaLoja() { return notaLoja; }

    public void setId(Long id) { this.id = id; }

    public void setProduto(Produto produto) { this.produto = produto; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public void setLoja(Loja loja) { this.loja = loja; }

    public void setNotaProduto(Integer notaProduto) { this.notaProduto = notaProduto; }

    public void setNotaLoja(Integer notaLoja) { this.notaLoja = notaLoja; }
}
