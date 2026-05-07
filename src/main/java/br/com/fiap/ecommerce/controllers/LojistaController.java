package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.services.LojistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lojistas")
public class LojistaController {
    private final LojistaService lojistaService;


    public LojistaController(LojistaService lojistaService) {
        this.lojistaService = lojistaService;
    }

    @GetMapping("/{id}")
    public Lojista buscarPorId(@PathVariable Long id) {
        return lojistaService.buscarPorId(id);
    }

    @GetMapping
    public List<Lojista> listarLojistas() {
        return lojistaService.listarLojistas();
    }

    @PostMapping
    public Lojista salvarBanco(@RequestBody Lojista lojista) {
        return lojistaService.salvarBanco(lojista);
    }

    @PutMapping
    public Lojista atualizarDados(@RequestBody Lojista lojista) {
        return lojistaService.atualizarDados(lojista);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable Long id) {
        lojistaService.deletarConta(id);
    }

}
