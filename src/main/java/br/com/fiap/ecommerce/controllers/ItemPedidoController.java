package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.ItemPedido;
import br.com.fiap.ecommerce.services.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/itens-pedido")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarTodos() {
        return ResponseEntity.ok(itemPedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(itemPedidoService.buscarPorId(id));
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<ItemPedido>> listarPorPedido(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(itemPedidoService.listarPorPedido(pedidoId));
    }

    @PostMapping
    public ResponseEntity<ItemPedido> criar(@RequestBody @Valid ItemPedido itemPedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.salvar(itemPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizar(@PathVariable UUID id, @RequestBody @Valid ItemPedido itemPedido) {
        return ResponseEntity.ok(itemPedidoService.atualizar(id, itemPedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        itemPedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
