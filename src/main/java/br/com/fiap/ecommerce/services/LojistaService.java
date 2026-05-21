package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.repositories.LojistaRepository;
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
public class LojistaService {

    private final LojistaRepository lojistaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public Lojista buscarPorId(UUID id) {
        return lojistaRepository.findById(id).orElse(null);
    }

    public Lojista buscarPorEmail(String email) {
        return lojistaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Lojista não encontrado."));
    }

    public List<Lojista> listarLojistas() {
        return lojistaRepository.findAll();
    }

    public Lojista salvarBanco(Lojista lojista) {
        lojista.setSenha(passwordEncoder.encode(lojista.getSenha()));
        return lojistaRepository.save(lojista);
    }

    public Lojista atualizarDados(Lojista lojista) {
        return lojistaRepository.save(lojista);
    }

    public void deletarConta(UUID id) {
        lojistaRepository.deleteById(id);
    }

    public void alterarSenha(String email, String senhaAtual, String novaSenha) {
        Lojista lojista = lojistaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Lojista não encontrado com o e-mail: " + email));

        if (!passwordEncoder.matches(senhaAtual, lojista.getSenha())) {
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

        lojista.setSenha(passwordEncoder.encode(novaSenha));
        lojistaRepository.save(lojista);
    }

    public String autenticar(String email, String senha) {
        Lojista lojista = lojistaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos."));

        if (!passwordEncoder.matches(senha, lojista.getSenha())) {
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        var userDetails = new User(
                lojista.getEmail(),
                lojista.getSenha(),
                List.of(new SimpleGrantedAuthority("ROLE_LOJISTA"))
        );

        return jwtService.generateToken(userDetails, Map.of(
                "id", lojista.getId().toString(),
                "nome", lojista.getNome(),
                "role", "ROLE_LOJISTA"
        ));
    }
}
