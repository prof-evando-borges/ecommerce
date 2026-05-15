package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Cartao;
import br.com.fiap.ecommerce.services.CartaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listarTodos() {
        return ResponseEntity.ok(cartaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(cartaoService.buscarPorId(id));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Cartao>> listarPorCliente(@PathVariable UUID idCliente) {
        return ResponseEntity.ok(cartaoService.listarPorCliente(idCliente));
    }

    @GetMapping("/cliente/{idCliente}/ativos")
    public ResponseEntity<List<Cartao>> listarAtivosDoCliente(@PathVariable UUID idCliente) {
        return ResponseEntity.ok(cartaoService.listarAtivosDoCliente(idCliente));
    }

    @PostMapping
    public ResponseEntity<Cartao> salvar(@RequestBody @Valid Cartao cartao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoService.salvar(cartao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cartao> atualizar(@PathVariable UUID id, @RequestBody @Valid Cartao cartao) {
        return ResponseEntity.ok(cartaoService.atualizar(id, cartao));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Cartao> inativar(@PathVariable UUID id) {
        return ResponseEntity.ok(cartaoService.inativar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        cartaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}