package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.UnidadeMedidaPeso;
import br.com.fiap.ecommerce.repositories.UnidadeMedidaPesoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UnidadeMedidaPesoService {

    private final UnidadeMedidaPesoRepository repository;

    @Transactional
    public UnidadeMedidaPeso salvar(UnidadeMedidaPeso unidade) {
        if (unidade.getUnidadeMedidaPeso() == null || unidade.getUnidadeMedidaPeso().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da unidade de peso é obrigatória.");
        }
        return repository.save(unidade);
    }

    public List<UnidadeMedidaPeso> listarTodas() {
        return repository.findAll();
    }

    public UnidadeMedidaPeso buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unidade de medida de peso não encontrada."));
    }

    @Transactional
    public void deletar(UUID id) {
        UnidadeMedidaPeso unidade = buscarPorId(id);
        repository.delete(unidade);
    }
}