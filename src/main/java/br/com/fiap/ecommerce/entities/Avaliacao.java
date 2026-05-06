package br.com.fiap.ecommerce.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProduto;
    private Long idCliente;
    private Long idLoja;

    private Integer notaLoja;
    private Integer notaProduto;

    public Avaliacao() {
    }

    public Avaliacao(Long idProduto, Long idCliente, Long idLoja, Integer notaLoja, Integer notaProduto) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.idLoja = idLoja;
        this.notaLoja = notaLoja;
        this.notaProduto = notaProduto;
    }

    public Long getId() {
        return id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public Integer getNotaLoja() {
        return notaLoja;
    }

    public Integer getNotaProduto() {
        return notaProduto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public void setNotaLoja(Integer notaLoja) {
        this.notaLoja = notaLoja;
    }

    public void setNotaProduto(Integer notaProduto) {
        this.notaProduto = notaProduto;
    }
}
