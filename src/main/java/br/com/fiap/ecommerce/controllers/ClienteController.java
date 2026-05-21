package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.models.AlterarSenhaRequest;
import br.com.fiap.ecommerce.models.AutenticarRequest;
import br.com.fiap.ecommerce.models.JwtResponse;
import br.com.fiap.ecommerce.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable UUID id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente salvarBanco(@RequestBody Cliente cliente) {
        return clienteService.salvarBanco(cliente);
    }

    @PutMapping
    public Cliente atualizarDados(@RequestBody Cliente cliente) {
        return clienteService.atualizarDados(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletarConta(@PathVariable UUID id) {
        clienteService.deletarConta(id);
    }

    @PutMapping("/senha")
    public ResponseEntity<String> alterarSenha(@RequestBody AlterarSenhaRequest request) {
        try {
            clienteService.alterarSenha(request.getEmail(), request.getSenhaAtual(), request.getNovaSenha());
            return ResponseEntity.ok("Senha alterada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> autenticar(@RequestBody AutenticarRequest request) {
        try {
            String token = clienteService.autenticar(request.getEmail(), request.getSenha());
            Cliente cliente = clienteService.buscarPorEmail(request.getEmail());
            return ResponseEntity.ok(new JwtResponse(token, cliente.getId(), cliente.getNome(), cliente.getEmail(), "ROLE_CLIENTE"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
