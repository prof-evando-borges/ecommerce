package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Cupom;
import br.com.fiap.ecommerce.services.CupomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cupons")
public class CupomController {

    private final CupomService cupomService;

    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @GetMapping
    public ResponseEntity<List<Cupom>> listarTodos() {
        return ResponseEntity.ok(cupomService.listarTodos());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Cupom>> listarAtivos() {
        return ResponseEntity.ok(cupomService.listarAtivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cupom> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(cupomService.buscarPorId(id));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Cupom> buscarPorCodigo(@PathVariable String codigo) {
        return ResponseEntity.ok(cupomService.buscarPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<Cupom> salvar(@RequestBody @Valid Cupom cupom) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cupomService.salvar(cupom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cupom> atualizar(@PathVariable UUID id, @RequestBody @Valid Cupom cupom) {
        return ResponseEntity.ok(cupomService.atualizar(id, cupom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        cupomService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}