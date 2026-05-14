package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Estoque;
import br.com.fiap.ecommerce.entities.Lojista;
import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.entities.Setor;
import br.com.fiap.ecommerce.repositories.EstoqueRepository;
import br.com.fiap.ecommerce.repositories.LojistaRepository;
import br.com.fiap.ecommerce.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private LojistaRepository lojistaRepository;

    public Estoque consutarEstoque(UUID id){
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));
    }

    public List<Estoque> consultarEstoquesPorResponsavel(Long id){
        return estoqueRepository.findByResponsavelId(id);
    }

    public void deletar(UUID id) {
        estoqueRepository.deleteById(id);
    }

    public Estoque adicionarEstoque(Estoque estoque) {
        if (estoque.getIdLojista() == null) {
            UUID idLojista = estoque.getIdLojista().getId();
            Lojista lojista = lojistaRepository.findById(idLojista)
                    .orElseThrow(() ->
                            new RuntimeException("Lojista não encontrado"));
            estoque.setIdLojista(lojista);
        }
        return estoqueRepository.save(estoque);
    }
}