package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    Optional<Avaliacao> findByCliente_IdAndProduto_Id(
            Long clienteId,
            Long produtoId
    );
}