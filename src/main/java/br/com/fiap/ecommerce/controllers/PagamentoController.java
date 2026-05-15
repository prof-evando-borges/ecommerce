package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Pagamento;
import br.com.fiap.ecommerce.models.StatusPagamentoEnum;
import br.com.fiap.ecommerce.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarTodos() {
        return ResponseEntity.ok(pagamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(pagamentoService.buscarPorId(id));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Pagamento>> listarPorCliente(@PathVariable UUID idCliente) {
        return ResponseEntity.ok(pagamentoService.listarPorCliente(idCliente));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pagamento>> listarPorStatus(@PathVariable StatusPagamentoEnum status) {
        return ResponseEntity.ok(pagamentoService.listarPorStatus(status));
    }

    @PostMapping
    public ResponseEntity<Pagamento> processar(@RequestBody @Valid Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.processar(pagamento));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Pagamento> atualizarStatus(@PathVariable UUID id,
                                                     @RequestBody StatusPagamentoEnum novoStatus) {
        return ResponseEntity.ok(pagamentoService.atualizarStatus(id, novoStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}