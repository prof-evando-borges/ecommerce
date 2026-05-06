package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
}
