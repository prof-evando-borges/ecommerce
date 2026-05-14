package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.services.MensagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping
    public ResponseEntity<List<Mensagem>> listarTodas() {
        return ResponseEntity.ok(mensagemService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(mensagemService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Mensagem> enviarMensagem(@RequestBody @Valid Mensagem mensagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemService.enviarMensagem(mensagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensagem> atualizar(@PathVariable String id, @RequestBody @Valid Mensagem mensagem) {
        mensagem.setId(id);
        return ResponseEntity.ok(mensagemService.atualizar(mensagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        mensagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}