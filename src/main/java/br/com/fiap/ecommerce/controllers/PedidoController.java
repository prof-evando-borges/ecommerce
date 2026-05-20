package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Pedido;
import br.com.fiap.ecommerce.services.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable UUID clienteId) {
        return ResponseEntity.ok(pedidoService.listarPorCliente(clienteId));
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody @Valid Pedido pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable UUID id, @RequestBody @Valid Pedido pedido) {
        return ResponseEntity.ok(pedidoService.atualizar(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
