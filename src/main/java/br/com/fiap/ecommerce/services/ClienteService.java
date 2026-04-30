package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(Long id) {
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

    public void deletarConta(Long id) {
        clienteRepository.deleteById(id);
    }
}
