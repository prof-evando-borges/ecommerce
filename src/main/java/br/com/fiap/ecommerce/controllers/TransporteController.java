package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController(value = "/api/v1/transportes")
public class TransporteController {

    @Autowired
    private TransportadoraService service;

    @GetMapping
    public ResponseEntity<List<Transportadora>> findAll(){
        List<Transportadora> obj = service.listarTodos();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transportadora> findById(@PathVariable Long id){
        Transportadora obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/criar-transportadora")
    public ResponseEntity<Transportadora> criarTransportadora(@RequestBody Transportadora obj){
        Transportadora transportadora = obj;
        service.salvar(transportadora);
        return ResponseEntity.ok().body(transportadora);
    }

    @PostMapping(value = "/atualizar-transportadora")
    public ResponseEntity<Transportadora> atualizarTransportadora(@RequestBody Transportadora obj){
        Transportadora transportadora = obj;
        service.salvar(transportadora);
        return ResponseEntity.ok().body(transportadora);
    }

}
