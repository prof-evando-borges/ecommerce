package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.services.MensagemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping
    public List<Mensagem> listarTodas() {
        return mensagemService.listarTodas();
    }

    @GetMapping("/{id}")
    public Mensagem buscarPorId(@PathVariable Long id) {
        return mensagemService.buscarPorId(id);
    }

    @PostMapping
    public Mensagem enviarMensagem(@RequestBody @Valid Mensagem mensagem) {
        return mensagemService.enviarMensagem(mensagem);
    }

    @PutMapping
    public Mensagem atualizar(@RequestBody @Valid Mensagem mensagem) {
        return mensagemService.atualizar(mensagem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        mensagemService.deletar(id);
    }
}