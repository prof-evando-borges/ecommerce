package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.UnidadeMedidaTamanho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeMedidaTamanhoRepository extends JpaRepository<UnidadeMedidaTamanho, Integer> {

    Optional<UnidadeMedidaTamanho> findByUnidadeMedidaTamanho(String unidadeMedidaTamanho);
}