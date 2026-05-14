package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Avaliacao;
import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.repositories.AvaliacaoRepository;
import br.com.fiap.ecommerce.repositories.ClienteRepository;
import br.com.fiap.ecommerce.repositories.LojistaRepository;
import br.com.fiap.ecommerce.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Avaliacao buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Avaliação não encontrada"));
    }

    public Avaliacao salvar(Avaliacao avaliacao) {

        UUID clienteId = avaliacao.getCliente().getId();
        UUID produtoId = avaliacao.getProduto().getId();
        UUID lojaId = avaliacao.getLojista().getId();

        repository.findByCliente_IdAndProduto_Id(clienteId, produtoId)
                .ifPresent(a -> {
                    throw new RuntimeException(
                            "Cliente já avaliou esse produto"
                    );
                });

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        Lojista lojista = lojistaRepository.findById(lojaId)
                .orElseThrow(() ->
                        new RuntimeException("Loja não encontrada"));

        avaliacao.setProduto(produto);
        avaliacao.setCliente(cliente);
        avaliacao.setLojista(lojista);

        return repository.save(avaliacao);
    }

    public void deletar(UUID id) {

        Avaliacao avaliacao = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Avaliação não encontrada"));

        repository.delete(avaliacao);
    }
}