package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    private final CategoriaService categoriaService;

    @Transactional
    public Produto salvar(Produto produto) {

        if (produto.getNomeProduto() == null || produto.getNomeProduto().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }

        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");
        }

        if (produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            throw new IllegalArgumentException("O produto deve estar associado a uma categoria válida.");
        }

        categoriaService.buscarPorId(produto.getCategoria().getId());

        validarProdutoSimilar(produto);

        validarEstruturaFisicaProduto(produto);

        Optional<Produto> existente = repository.findByNomeProduto(produto.getNomeProduto());

        if (existente.isPresent() && !existente.get().getId().equals(produto.getId())) {
            throw new IllegalArgumentException("Já existe um produto com este nome.");
        }

        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado para o ID: " + id));
    }

    @Transactional
    public void deletar(UUID id) {
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }

    private void validarProdutoSimilar(Produto produto) {

        if (produto.getPeso() == null
                || produto.getUnidadeMedidaPeso() == null
                || produto.getUnidadeMedidaPeso().getId() == null) {
            return;
        }

        List<Produto> produtosSimilares =
                repository.buscarProdutosSimilares(
                        produto.getNomeProduto(),
                        produto.getCategoria().getId(),
                        produto.getUnidadeMedidaPeso().getId(),
                        produto.getPeso()
                );

        boolean existeProdutoSimilar;

        if (produto.getId() == null) {

            existeProdutoSimilar = !produtosSimilares.isEmpty();

        } else {

            existeProdutoSimilar = produtosSimilares.stream()
                    .anyMatch(p -> !p.getId().equals(produto.getId()));
        }

        if (existeProdutoSimilar) {
            throw new IllegalArgumentException(
                    "Já existe um produto similar cadastrado nesta categoria."
            );
        }
    }
    private void validarEstruturaFisicaProduto(Produto produto) {

        boolean possuiPeso =
                produto.getPeso() != null;

        boolean possuiDimensoes =
                produto.getAltura() != null
                        || produto.getLargura() != null
                        || produto.getProfundidade() != null;

        if (possuiPeso
                && produto.getUnidadeMedidaPeso() == null) {

            throw new IllegalArgumentException(
                    "Produtos com peso devem possuir unidade de medida de peso."
            );
        }

        if (possuiDimensoes
                && produto.getUnidadeMedidaTamanho() == null) {

            throw new IllegalArgumentException(
                    "Produtos com dimensões devem possuir unidade de medida de tamanho."
            );
        }
    }
}