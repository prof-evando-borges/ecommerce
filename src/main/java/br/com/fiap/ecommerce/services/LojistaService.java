package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

import br.com.fiap.ecommerce.repositories.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LojistaService {

    @Autowired
    private LojistaRepository lojistaRepository;

    public LojistaService(LojistaRepository lojistaRepository) {
        this.lojistaRepository = lojistaRepository;
    }

    public Lojista buscarPorId(UUID id) {
        return lojistaRepository.findById(id).orElse(null);
    }

    public  List<Lojista> listarLojistas() {
        return lojistaRepository.findAll();
    }

    public Lojista salvarBanco(Lojista lojista) {
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

        if (!lojista.getSenha().equals(senhaAtual)) {
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

        lojista.setSenha(novaSenha);
        lojistaRepository.save(lojista);
    }

    public Lojista autenticar(String email, String senha) {
        Lojista lojista = lojistaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos."));

        if (!lojista.getSenha().equals(senha)) {
            throw new RuntimeException("E-mail ou senha inválidos.");
        }

        return lojista;
    }
}
