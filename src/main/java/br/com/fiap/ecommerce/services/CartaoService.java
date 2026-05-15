package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cartao;
import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.exceptions.CartaoException;
import br.com.fiap.ecommerce.repositories.CartaoRepository;
import br.com.fiap.ecommerce.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cartao> listarTodos() {
        return cartaoRepository.findAll();
    }

    public List<Cartao> listarPorCliente(UUID idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new CartaoException("Cliente não encontrado com id: " + idCliente));
        return cartaoRepository.findByCliente(cliente);
    }

    public List<Cartao> listarAtivosDoCliente(UUID idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new CartaoException("Cliente não encontrado com id: " + idCliente));
        return cartaoRepository.findByClienteAndAtivo(cliente, true);
    }

    public Cartao buscarPorId(UUID id) {
        return cartaoRepository.findById(id)
                .orElseThrow(() -> new CartaoException("Cartão não encontrado com id: " + id));
    }

    public Cartao salvar(Cartao cartao) {
        UUID idCliente = cartao.getCliente().getId();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new CartaoException("Cliente não encontrado com id: " + idCliente));
        cartao.setCliente(cliente);
        return cartaoRepository.save(cartao);
    }

    public Cartao atualizar(UUID id, Cartao cartao) {
        Cartao existente = buscarPorId(id);
        existente.setTitular(cartao.getTitular());
        existente.setUltimosDigitos(cartao.getUltimosDigitos());
        existente.setBandeira(cartao.getBandeira());
        existente.setValidade(cartao.getValidade());
        existente.setAtivo(cartao.isAtivo());
        return cartaoRepository.save(existente);
    }

    public void deletar(UUID id) {
        Cartao existente = buscarPorId(id);
        cartaoRepository.delete(existente);
    }

    public Cartao inativar(UUID id) {
        Cartao existente = buscarPorId(id);
        if (!existente.isAtivo()) {
            throw new CartaoException("O cartão já está inativo");
        }
        existente.setAtivo(false);
        return cartaoRepository.save(existente);
    }
}