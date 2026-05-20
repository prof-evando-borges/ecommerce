package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, UUID> {
    List<Estoque> findByLojistaId(UUID idLojista);
}
