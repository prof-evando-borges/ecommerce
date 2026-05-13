package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Pagamento;
import br.com.fiap.ecommerce.models.StatusPagamentoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {

    List<Pagamento> findByCliente(Cliente cliente);

    List<Pagamento> findByStatus(StatusPagamentoEnum status);

    List<Pagamento> findByClienteAndStatus(Cliente cliente, StatusPagamentoEnum status);
}