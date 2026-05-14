package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, UUID> {

    Optional<Cupom> findByCodigo(String codigo);

    List<Cupom> findByAtivo(boolean ativo);
}