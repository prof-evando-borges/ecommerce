package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.UnidadeMedidaTamanho;
import br.com.fiap.ecommerce.repositories.UnidadeMedidaTamanhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadeMedidaTamanhoService {

    private final UnidadeMedidaTamanhoRepository repository;

    @Transactional
    public UnidadeMedidaTamanho salvar(UnidadeMedidaTamanho unidade) {
        if (unidade.getUnidadeMedidaTamanho() == null || unidade.getUnidadeMedidaTamanho().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da unidade de tamanho é obrigatória.");
        }
        return repository.save(unidade);
    }

    public List<UnidadeMedidaTamanho> listarTodas() {
        return repository.findAll();
    }

    public UnidadeMedidaTamanho buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unidade de medida de tamanho não encontrada."));
    }

    @Transactional
    public void deletar(String id) {
        UnidadeMedidaTamanho unidade = buscarPorId(id);
        repository.delete(unidade);
    }
}