package br.com.fiap.ecommerce.services;


import br.com.fiap.ecommerce.entities.Avaliacao;
import br.com.fiap.ecommerce.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.entities.Loja;
import br.com.fiap.ecommerce.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LojistaRepository lojistaRepository;

    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    public Avaliacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    public Avaliacao salvar(Avaliacao avaliacao) {

        Long clienteId = avaliacao.getCliente().getId();
        Long produtoId = avaliacao.getProduto().getId();

        repository.findByClienteIdAndProdutoId(clienteId, produtoId)
                .ifPresent(a -> {
                    throw new RuntimeException("Cliente já avaliou esse produto");
                });

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Loja loja = lojistaRepository.findById(avaliacao.getLoja().getId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));

        avaliacao.setProduto(produto);
        avaliacao.setCliente(cliente);
        avaliacao.setLoja(loja);

        return repository.save(avaliacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}