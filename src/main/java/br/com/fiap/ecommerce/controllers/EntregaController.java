package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Entrega;
import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.models.StatusEnum;
import br.com.fiap.ecommerce.services.EntregaService;
import br.com.fiap.ecommerce.services.TransportadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @PostMapping()
    public ResponseEntity<Entrega> criar(@RequestBody @Valid Entrega obj){
        service.criar(obj);
        return ResponseEntity.ok().body(obj);
    }

    // QUAL A DIFERENCA??
    /*@PostMapping()
    public ResponseEntity<Entrega> criarEntrega(@RequestBody @Valid Entrega obj){
        service.salvar(obj);
        return ResponseEntity.ok().body(obj);
    }*/

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll(){
        List<Entrega> obj = service.listarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable UUID id){
        Entrega obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}/atualiza-status")
        public ResponseEntity<Void> atualizarStatus(@RequestBody StatusEnum statusEnum, @PathVariable UUID id){
        service.atualizarStatus(statusEnum, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/atualiza-transportadora")
    public ResponseEntity<Void> atualizarTransportadora(@PathVariable UUID id,@RequestBody @Valid UUID idTransportadora){
        service.atualizaTransportadora(idTransportadora, id);
        return ResponseEntity.noContent().build();
    }

}