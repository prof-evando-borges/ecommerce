package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.ItemPedido;
import br.com.fiap.ecommerce.repositories.ItemPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository repository;

    @Transactional
    public ItemPedido salvar(ItemPedido item) {
        // 1. Validação de Quantidade
        if (item.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade do item deve ser maior que zero.");
        }

        // 2. Validação de IDs obrigatórios
        if (item.getIdProduto() == null || item.getIdPedido() == null) {
            throw new IllegalArgumentException("Produto e Pedido são obrigatórios para o item.");
        }

        if (item.getValorItem() == null || item.getValorItem() <= 0) {
            throw new IllegalArgumentException("O valor do item deve ser positivo.");
        }

        return repository.save(item);
    }

    public List<ItemPedido> listarTodos() {
        return repository.findAll();
    }

    public ItemPedido buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado com o ID: " + id));
    }

    @Transactional
    public void deletar(String id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Item não encontrado.");
        }
        repository.deleteById(id);
    }
}
