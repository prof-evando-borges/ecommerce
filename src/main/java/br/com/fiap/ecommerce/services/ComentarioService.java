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

    public List<Comentario> listar() {
        return repository.findAll();
    }

    public Comentario buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public List<Comentario> buscarPorAvaliacao(UUID avaliacaoId) {
        return repository.findByAvaliacao_Id(avaliacaoId);
    }

    public Comentario salvar(Comentario comentario) {

        UUID avaliacaoId = comentario.getAvaliacao().getId();

        Avaliacao avaliacao = avaliacaoRepository.findById(avaliacaoId)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        if (!avaliacao.getCliente().getId()
                .equals(comentario.getCliente().getId())) {

            throw new RuntimeException("Cliente não pode comentar avaliação de outro cliente");
        }

        if (comentario.getComentario() == null || comentario.getComentario().trim().isEmpty()) {
            throw new RuntimeException("Comentário não pode ser vazio");
        }

        comentario.setAvaliacao(avaliacao);

        return repository.save(comentario);
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}