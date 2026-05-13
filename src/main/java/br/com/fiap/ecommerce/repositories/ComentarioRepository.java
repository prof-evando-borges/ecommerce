package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface ComentarioRepository extends JpaRepository<Comentario, UUID> {

    // Buscar comentários por avaliação
    List<Comentario> findByAvaliacao_Id(Long avaliacaoId);

}