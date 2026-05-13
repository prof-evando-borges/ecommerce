package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SetorRepository extends JpaRepository<Setor, UUID> {
}
