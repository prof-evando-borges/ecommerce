package br.com.fiap.ecommerce.repositories;
 
import br.com.fiap.ecommerce.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository[cite: 2]
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}[cite: 2]