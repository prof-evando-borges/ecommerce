package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void alterarSenha(String email, String senhaAtual, String novaSenha) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o e-mail: " + email));

        if (!cliente.getSenha().equals(senhaAtual)) {
            throw new RuntimeException("Senha atual incorreta.");
        }

        List<String> erros = new ArrayList<>();

        if (novaSenha.length() < 8) {
            erros.add("A nova senha deve ter no mínimo 8 caracteres.");
        }

        if (!Character.isUpperCase(novaSenha.charAt(0))) {
            erros.add("A nova senha deve começar com letra maiúscula.");
        }

        boolean temCaractereEspecial = novaSenha.chars()
                .anyMatch(c -> !Character.isLetterOrDigit(c));

        if (!temCaractereEspecial) {
            erros.add("A nova senha deve conter pelo menos um caractere especial.");
        }

        if (!erros.isEmpty()) {
            throw new RuntimeException("A nova senha não atende aos requisitos: " + String.join(" | ", erros));
        }

        cliente.setSenha(novaSenha);
        clienteRepository.save(cliente);
    }

    public Cliente autenticar(String email, String senha) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos."));

        if (!cliente.getSenha().equals(senha)) {
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        return cliente;
    }
}
