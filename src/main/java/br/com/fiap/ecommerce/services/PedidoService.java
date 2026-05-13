package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Categoria;
import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.repositories.CategoriaRepository;
import br.com.fiap.ecommerce.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private PedidoRepository repository;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (pedido.getNumeroPedido() == null || pedido.getNumeroPedido() == 0) {
            throw new IllegalArgumentException("O número do pedido é obrigatório.");
        }

        Optional<Pedido> existente = repository.findByNumeroPedido(pedido.getNumeroPedido());
        if (existente.isPresent() && !existente.get().getNumeroPedido().equals(pedido.getNumeroPedido())) {
            throw new IllegalArgumentException("Já existe um pedido cadastrada com este numero.");
        }

        return repository.save(pedido);
    }

    public Pedido buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com o número: " + id));
    }
}
