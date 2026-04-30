package br.com.fiap.ecommerce.services;


import com.exemplo.demo.entity.Comentario;
import com.exemplo.demo.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    public Comentario salvar(Comentario comentario) {
        return repository.save(comentario);
    }

    public List<Comentario> listarTodos() {
        return repository.findAll();
    }

    public Comentario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}