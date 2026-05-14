package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.models.AlterarSenhaRequest;
import br.com.fiap.ecommerce.models.AutenticarRequest;
import br.com.fiap.ecommerce.services.LojistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lojistas")
public class LojistaController {
    private final LojistaService lojistaService;


    public LojistaController(LojistaService lojistaService) {
        this.lojistaService = lojistaService;
    }

    @GetMapping("/{id}")
    public Lojista buscarPorId(@PathVariable UUID id) {
        return lojistaService.buscarPorId(id);
    }

    @GetMapping
    public List<Lojista> listarLojistas() {
        return lojistaService.listarLojistas();
    }

    @PostMapping
    public Lojista salvarBanco(@RequestBody Lojista lojista) {
        return lojistaService.salvarBanco(lojista);
    }

    @PutMapping
    public Lojista atualizarDados(@RequestBody Lojista lojista) {
        return lojistaService.atualizarDados(lojista);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable UUID id) {
        lojistaService.deletarConta(id);
    }

    @PutMapping("/senha")
    public ResponseEntity<String> alterarSenha(@RequestBody AlterarSenhaRequest request) {
        try {
            lojistaService.alterarSenha(request.getEmail(), request.getSenhaAtual(), request.getNovaSenha());
            return ResponseEntity.ok("Senha alterada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Lojista> autenticar(@RequestBody AutenticarRequest request) {
        try {
            Lojista lojista = lojistaService.autenticar(request.getEmail(), request.getSenha());
            return ResponseEntity.ok(lojista);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
