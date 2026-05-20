package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, UUID> {

    List<ItemPedido> findByPedidoId(UUID pedidoId);
}
