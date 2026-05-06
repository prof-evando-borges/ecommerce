package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    void adicionarProduto(Long estoqueId, Produto produto);
    void removerDoEstoque(Long estoqueId, Produto produto);
}
