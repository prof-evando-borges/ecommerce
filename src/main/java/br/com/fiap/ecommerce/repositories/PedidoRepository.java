package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    List<Pedido> findByClienteId(UUID clienteId);
}
