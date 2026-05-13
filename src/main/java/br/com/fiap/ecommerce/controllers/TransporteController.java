package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.services.TransportadoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RestController(value = "/api/v1/transportadoras")
public class TransporteController {

    @Autowired
    private TransportadoraService service;

    @GetMapping
    public ResponseEntity<List<Transportadora>> findAll(){
        List<Transportadora> obj = service.listarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transportadora> findById(@PathVariable UUID id){
        Transportadora obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<Transportadora> criarTransportadora(@RequestBody @Valid Transportadora obj){
        service.criar(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Transportadora> atualizarTransportadora(@PathVariable UUID id,@RequestBody @Valid Transportadora obj){
        service.atualizar(obj, id);
        return ResponseEntity.ok().body(obj);
    }

}
