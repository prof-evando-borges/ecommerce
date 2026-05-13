package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
        void salvar(Long id, Pedido pedido);
        void buscarPorId(Long id, Pedido pedido);

    Optional<Object> findById(String id);
}