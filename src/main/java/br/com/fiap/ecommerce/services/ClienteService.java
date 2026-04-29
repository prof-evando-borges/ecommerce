package br.com.fiap.ecommerce.services;

import br.com.fiap.teste.entities.Produto;
import br.com.fiap.teste.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findByNomeContainingIgnoreCase(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public  List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
