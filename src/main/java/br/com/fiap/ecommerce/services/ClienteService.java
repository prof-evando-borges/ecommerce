package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.repositories.ClienteRepository;
import br.com.fiap.ecommerce.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Cliente buscarPorId(UUID id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente salvarBanco(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
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

        if (!passwordEncoder.matches(senhaAtual, cliente.getSenha())) {
            throw new RuntimeException("Senha atual incorreta.");
        }

        List<String> erros = new ArrayList<>();

        if (novaSenha.length() < 8) {
            erros.add("A nova senha deve ter no mínimo 8 caracteres.");
        }
        if (!Character.isUpperCase(novaSenha.charAt(0))) {
            erros.add("A nova senha deve começar com letra maiúscula.");
        }
        boolean temCaractereEspecial = novaSenha.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        if (!temCaractereEspecial) {
            erros.add("A nova senha deve conter pelo menos um caractere especial.");
        }
        if (!erros.isEmpty()) {
            throw new RuntimeException("A nova senha não atende aos requisitos: " + String.join(" | ", erros));
        }

        cliente.setSenha(passwordEncoder.encode(novaSenha));
        clienteRepository.save(cliente);
    }

    public String autenticar(String email, String senha) {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos."));

        if (!passwordEncoder.matches(senha, cliente.getSenha())) {
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        var userDetails = new User(
                cliente.getEmail(),
                cliente.getSenha(),
                List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"))
        );

        return jwtService.generateToken(userDetails, Map.of(
                "id", cliente.getId().toString(),
                "nome", cliente.getNome(),
                "role", "ROLE_CLIENTE"
        ));
    }
}
