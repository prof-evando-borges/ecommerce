package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    Optional<Produto> findByNomeProduto(String nomeProduto);

    @Query("""
    SELECT p FROM Produto p
    WHERE
        LOWER(p.nomeProduto) = LOWER(:nomeProduto)
        AND p.categoria.id = :categoriaId
        AND p.unidadeMedidaPeso.id = :unidadeMedidaPesoId
        AND p.peso IS NOT NULL
        AND ABS(p.peso - :peso) <= 0.1
""")
    List<Produto> buscarProdutosSimilares(
            @Param("nomeProduto") String nomeProduto,
            @Param("categoriaId") UUID categoriaId,
            @Param("unidadeMedidaPesoId") UUID unidadeMedidaPesoId,
            @Param("peso") Double peso
    );
}