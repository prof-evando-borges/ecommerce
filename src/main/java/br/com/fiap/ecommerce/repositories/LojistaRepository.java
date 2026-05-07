package br.com.fiap.ecommerce.repositories;


import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojistaRepository extends JpaRepository<Lojista, Long> {
}