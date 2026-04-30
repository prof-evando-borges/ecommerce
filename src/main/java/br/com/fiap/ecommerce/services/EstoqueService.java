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

    public void incluirNoEstoque(Produto produto){
        estoqueRepository.adicionarProduto(produto);
    }
}
