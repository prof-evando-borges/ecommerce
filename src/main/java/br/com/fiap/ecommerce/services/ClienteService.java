package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(UUID id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public  List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente salvarBanco(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarDados(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarConta(UUID id) {
        clienteRepository.deleteById(id);
    }
}
