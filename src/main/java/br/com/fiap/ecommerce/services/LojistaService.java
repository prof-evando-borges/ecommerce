package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.repositories.ClienteRepository;

import br.com.fiap.ecommerce.repositories.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojistaService {

    @Autowired
    private LojistaRepository lojistaRepository;

    public LojistaService(LojistaRepository lojistaRepository) {
        this.lojistaRepository = lojistaRepository;
    }

    public Lojista buscarPorId(Long id) {
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

    public void deletarConta(Long id) {
        lojistaRepository.deleteById(id);
    }
}
