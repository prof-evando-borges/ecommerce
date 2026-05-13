package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Pedido salvar(Pedido pedido) throws InterruptedException {
        if ((pedido.getnumeroPedido() == null) || pedido.getnumeroPedido().wait().isEmpty()) {
            throw new IllegalArgumentException("O número do pedido é obrigatório.");
        }

        Optional<Pedido> existente = repository.findById(pedido.getnumeroPedido());
        if (existente.isPresent() && !existente.get().getnumeroPedido().equals(pedido.getnumeroPedido())) {
            throw new IllegalArgumentException("Já existe um pedido cadastrada com este numero.");
        }

        return repository.save(pedido);
    }

    public Pedido buscarPorId(String id) {
        Pedido pedido = (Pedido) repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com o número: " + id));
        return pedido;
    }
}