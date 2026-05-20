package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.repositories.EstoqueRepository;
import br.com.fiap.ecommerce.repositories.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private LojistaRepository lojistaRepository;

    public Estoque consultarEstoque(UUID id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
    }

    public List<Estoque> consultarEstoquesPorResponsavel(UUID idLojista) {
        return estoqueRepository.findByLojistaId(idLojista);
    }

    public Estoque adicionarEstoque(Estoque estoque) {
        if (estoque.getLojista() != null && estoque.getLojista().getId() != null) {
            UUID idLojista = estoque.getLojista().getId();
            Lojista lojista = lojistaRepository.findById(idLojista)
                    .orElseThrow(() -> new RuntimeException("Lojista não encontrado"));
            estoque.setLojista(lojista);
        }
        return estoqueRepository.save(estoque);
    }

    public void deletar(UUID id) {
        estoqueRepository.deleteById(id);
    }
}
