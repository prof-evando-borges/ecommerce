package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.ItemPedido;
import br.com.fiap.ecommerce.repositories.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarTodos() {
        return itemPedidoRepository.findAll();
    }

    public List<ItemPedido> listarPorPedido(UUID pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public ItemPedido buscarPorId(UUID id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item de pedido não encontrado para o ID: " + id));
    }

    @Transactional
    public ItemPedido salvar(ItemPedido itemPedido) {
        if (itemPedido.getPedido() == null || itemPedido.getPedido().getId() == null) {
            throw new IllegalArgumentException("O pedido é obrigatório.");
        }
        if (itemPedido.getProduto() == null || itemPedido.getProduto().getId() == null) {
            throw new IllegalArgumentException("O produto é obrigatório.");
        }
        if (itemPedido.getQuantidade() == null || itemPedido.getQuantidade() < 1) {
            throw new IllegalArgumentException("A quantidade deve ser ao menos 1.");
        }
        if (itemPedido.getValorItem() == null || itemPedido.getValorItem() <= 0) {
            throw new IllegalArgumentException("O valor do item deve ser maior que zero.");
        }
        return itemPedidoRepository.save(itemPedido);
    }

    @Transactional
    public ItemPedido atualizar(UUID id, ItemPedido itemPedido) {
        buscarPorId(id);
        itemPedido.setId(id);
        return itemPedidoRepository.save(itemPedido);
    }

    @Transactional
    public void deletar(UUID id) {
        ItemPedido item = buscarPorId(id);
        itemPedidoRepository.delete(item);
    }
}
