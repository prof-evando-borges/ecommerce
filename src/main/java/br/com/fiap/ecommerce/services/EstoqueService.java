package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.repositories.EstoqueRepository;
import br.com.fiap.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluirNoEstoque(Long estoqueId, Produto produto){
        Estoque estoque = estoqueRepository.findById(estoqueId)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        estoque.getProdutos().add(produto);

        estoqueRepository.save(estoque);
    }

    public void removerDoEstoque(Long estoqueId, Produto produto){
        Estoque estoque = estoqueRepository.findById(estoqueId)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        Produto produto1 = produtoRepository.getReferenceById(produto.getIdProduto());

        estoque.getProdutos().remove(produto1);

        estoqueRepository.save(estoque);
    }
}
