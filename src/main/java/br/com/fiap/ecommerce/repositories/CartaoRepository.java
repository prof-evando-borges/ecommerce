package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Cartao;
import br.com.fiap.ecommerce.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, UUID> {

    List<Cartao> findByCliente(Cliente cliente);

    List<Cartao> findByClienteAndAtivo(Cliente cliente, boolean ativo);
}