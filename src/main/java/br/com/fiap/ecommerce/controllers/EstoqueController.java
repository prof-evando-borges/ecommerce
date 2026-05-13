package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/{id}")
    public Estoque buscarPorId(@PathVariable UUID id){
        return estoqueService.consutarEstoque(id);
    }

    @GetMapping("/lojista/{id}")
    public List<Estoque> buscarPorIdDoResponsavel(@PathVariable Long id){
        return estoqueService.consultarEstoquesPorResponsavel(id);
    }

    @PostMapping
    public void adicionarEstoque(@RequestBody Estoque estoque){
        estoqueService.adicionarEstoque(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletarEstoque(@PathVariable UUID id){
        estoqueService.deletar(id);
    }

}
