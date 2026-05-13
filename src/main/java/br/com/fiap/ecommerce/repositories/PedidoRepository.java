package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    Optional<Pedido> findById(Integer numeroPedido);
}