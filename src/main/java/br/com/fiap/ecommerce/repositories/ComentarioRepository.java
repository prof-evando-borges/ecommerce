package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByProdutoId(Long produtoId);

    List<Comentario> findByClienteId(Long clienteId);
}
