package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorCliente(UUID clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Pedido buscarPorId(UUID id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado para o ID: " + id));
    }

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new IllegalArgumentException("O cliente é obrigatório.");
        }
        if (pedido.getValorFinal() == null || pedido.getValorFinal() <= 0) {
            throw new IllegalArgumentException("O valor final deve ser maior que zero.");
        }
        if (pedido.getDataEntrega() == null) {
            throw new IllegalArgumentException("A data de entrega é obrigatória.");
        }
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido atualizar(UUID id, Pedido pedido) {
        buscarPorId(id);
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void deletar(UUID id) {
        Pedido pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }
}
