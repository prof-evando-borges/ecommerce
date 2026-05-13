package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Entrega;
import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.services.EntregaService;
import br.com.fiap.ecommerce.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController(value = "/api/v1/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll(){
        List<Entrega> obj = service.listarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable Long id){
        Entrega obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/criar-entrega")
    public ResponseEntity<Entrega> criarEntrega(@RequestBody Entrega obj){
        Entrega entrega = obj;
        service.salvar(entrega);
        return ResponseEntity.ok().body(entrega);
    }

    @PostMapping(value = "/atualizar-entrega")
    public ResponseEntity<Entrega> atualizarTransportadora(@RequestBody Entrega obj){
        Entrega entrega = obj;
        service.salvar(entrega);
        return ResponseEntity.ok().body(entrega);
    }

}