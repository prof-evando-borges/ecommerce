package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, UUID> {

    Optional<Avaliacao> findByCliente_IdAndProduto_Id(
            UUID clienteId,
            UUID produtoId
    );
}