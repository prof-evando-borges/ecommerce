package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.UnidadeMedidaPeso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeMedidaPesoRepository extends JpaRepository<UnidadeMedidaPeso, Integer> {

    Optional<UnidadeMedidaPeso> findByUnidadeMedidaPeso(String unidadeMedidaPeso);
}