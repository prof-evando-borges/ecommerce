package br.com.fiap.ecommerce.repository;

import br.com.fiap.ecommerce.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository

public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
 