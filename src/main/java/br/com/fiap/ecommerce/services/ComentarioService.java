package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Avaliacao;
import br.com.fiap.ecommerce.entities.Comentario;
import br.com.fiap.ecommerce.repositories.AvaliacaoRepository;
import br.com.fiap.ecommerce.repositories.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // LISTAR TODOS
    public List<Comentario> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Comentario buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    // BUSCAR POR AVALIAÇÃO
    public List<Comentario> buscarPorAvaliacao(UUID avaliacaoId) {
        return repository.findByAvaliacao_Id(avaliacaoId);
    }

    // SALVAR
    public Comentario salvar(Comentario comentario) {

        UUID avaliacaoId = comentario.getAvaliacao().getId();

        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        comentario.setAvaliacao(avaliacao);

        return repository.save(comentario);
    }

    // DELETAR
    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}