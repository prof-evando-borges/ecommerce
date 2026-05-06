package br.com.fiap.ecommerce.repository;
import br.com.fiap.ecommerce.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
 