package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Setor;
import br.com.fiap.ecommerce.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @GetMapping
    public List<Setor> buscarSetores(){
        return setorService.listarSetores();
    }

    @GetMapping("/{id}")
    public Optional<Setor> buscarPorId(@PathVariable UUID id){
        return setorService.consultarSetor(id);
    }

    @PostMapping
    public void adicionarSetor(Setor setor){
        setorService.adicionarSetor(setor);
    }

    @DeleteMapping("/{id}")
    public void removerSetor(@PathVariable UUID id){
        setorService.removerSetor(id);
    }
}
