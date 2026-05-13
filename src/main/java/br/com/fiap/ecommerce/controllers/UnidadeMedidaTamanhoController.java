package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.UnidadeMedidaTamanho;
import br.com.fiap.ecommerce.services.UnidadeMedidaTamanhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/unidades-tamanho")
public class UnidadeMedidaTamanhoController {

    private final UnidadeMedidaTamanhoService unidadeMedidaTamanhoService;

    public UnidadeMedidaTamanhoController(UnidadeMedidaTamanhoService unidadeMedidaTamanhoService) {
        this.unidadeMedidaTamanhoService = unidadeMedidaTamanhoService;
    }

    @GetMapping("/{id}")
    public UnidadeMedidaTamanho buscarPorId(@PathVariable UUID id) {
        return unidadeMedidaTamanhoService.buscarPorId(id);
    }

    @GetMapping
    public List<UnidadeMedidaTamanho> listarUnidades() {
        return unidadeMedidaTamanhoService.listarTodas();
    }

    @PostMapping
    public UnidadeMedidaTamanho salvar(@RequestBody UnidadeMedidaTamanho unidade) {
        return unidadeMedidaTamanhoService.salvar(unidade);
    }

    @PutMapping
    public UnidadeMedidaTamanho atualizar(@RequestBody UnidadeMedidaTamanho unidade) {
        return unidadeMedidaTamanhoService.salvar(unidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        unidadeMedidaTamanhoService.deletar(id);
    }
}