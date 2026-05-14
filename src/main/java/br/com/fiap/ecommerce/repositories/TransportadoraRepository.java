package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, UUID> {
}
