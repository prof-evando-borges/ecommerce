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

    private static ItemPedidoRepository repository;

    @Transactional
    public static ItemPedido salvar(ItemPedido item) {
        if (item.getQuantidade() <= 0) {
            throw new IllegalArgumentException("A quantidade do item deve ser maior que zero.");
        }

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

    public ItemPedido buscarPorId(UUID id) {
        return repository.findById(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado com o ID: " + id));
    }

    @Transactional
    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Item não encontrado.");
        }
        repository.deleteById(id);
    }
}
