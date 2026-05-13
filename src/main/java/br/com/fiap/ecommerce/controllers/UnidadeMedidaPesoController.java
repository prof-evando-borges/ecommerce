package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.UnidadeMedidaPeso;
import br.com.fiap.ecommerce.services.UnidadeMedidaPesoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unidades-peso")
public class UnidadeMedidaPesoController {

    private final UnidadeMedidaPesoService unidadeMedidaPesoService;

    public UnidadeMedidaPesoController(UnidadeMedidaPesoService unidadeMedidaPesoService) {
        this.unidadeMedidaPesoService = unidadeMedidaPesoService;
    }

    @GetMapping("/{id}")
    public UnidadeMedidaPeso buscarPorId(@PathVariable String id) {
        return unidadeMedidaPesoService.buscarPorId(id);
    }

    @GetMapping
    public List<UnidadeMedidaPeso> listarUnidades() {
        return unidadeMedidaPesoService.listarTodas();
    }

    @PostMapping
    public UnidadeMedidaPeso salvar(@RequestBody UnidadeMedidaPeso unidade) {
        return unidadeMedidaPesoService.salvar(unidade);
    }

    @PutMapping
    public UnidadeMedidaPeso atualizar(@RequestBody UnidadeMedidaPeso unidade) {
        return unidadeMedidaPesoService.salvar(unidade);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        unidadeMedidaPesoService.deletar(id);
    }
}