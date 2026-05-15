package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {
    @Autowired
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Pedido salvar(Pedido pedido) {

        if (pedido.getNumeroPedido() == null || pedido.getNumeroPedido() <= 0) {
            throw new IllegalArgumentException("O número do pedido é obrigatório.");
        }

        Optional<Pedido> existente = repository.findById(pedido.getNumeroPedido());

        if (existente.isPresent() &&
                !existente.get().getNumeroPedido().equals(pedido.getNumeroPedido())) {

            throw new IllegalArgumentException("Já existe um pedido cadastrado com este número.");
        }

        return repository.save(pedido);
    }

    public Pedido buscarPorId(UUID id) {
        Pedido pedido = (Pedido) repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com o número: " + id));
        return pedido;
    }
}