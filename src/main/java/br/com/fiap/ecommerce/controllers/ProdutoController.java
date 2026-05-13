package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable UUID id) {
        return produtoService.buscarPorId(id);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @PutMapping
    public Produto atualizar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        produtoService.deletar(id);
    }
}