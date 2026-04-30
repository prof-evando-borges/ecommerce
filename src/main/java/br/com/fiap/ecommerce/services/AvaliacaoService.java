package br.com.fiap.ecommerce.services;


import br.com.fiap.ecommerce.entities.Avaliacao;
import br.com.fiap.ecommerce.repositories.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository repository;

    public AvaliacaoService(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    public Avaliacao criar(Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }

    public List<Avaliacao> listar() {
        return repository.findAll();
    }
}
