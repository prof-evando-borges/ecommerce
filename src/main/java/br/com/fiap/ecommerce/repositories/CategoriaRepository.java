package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

    Optional<Categoria> findByNomeCategoria(String nomeCategoria);
}