package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Categoria;
import br.com.fiap.ecommerce.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (pedido.getnumeroPedido() == null || pedido.getnumeroPedido().trim().isEmpty()) {
            throw new IllegalArgumentException("O número do pedido é obrigatório.");
        }

        Optional<Pedido> existente = repository.findBynumeroPedido(pedido.getnumeroPedido());
        if (existente.isPresent() && !existente.get().getnumeroPedido().equals(pedido.getnumeroPedido())) {
            throw new IllegalArgumentException("Já existe um pedido cadastrada com este numero.");
        }

        return repository.save(pedido);
    }

    public Pedido buscarPorId(String id) {
        return repository.findBynumeroId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com o número: " + id));
    }
