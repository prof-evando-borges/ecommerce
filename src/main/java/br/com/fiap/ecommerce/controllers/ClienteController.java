package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.services.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private final ClienteService clienteService;


    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
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
    public void deletarConta(@PathVariable Long id) {
        clienteService.deletarConta(id);
    }

}
