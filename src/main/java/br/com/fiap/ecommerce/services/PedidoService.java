package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Categoria;
import br.com.fiap.ecommerce.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (categoria.getNomeCategoria() == null || categoria.getNomeCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria é obrigatório.");
        }

        Optional<Categoria> existente = repository.findByNomeCategoria(categoria.getNomeCategoria());
        if (existente.isPresent() && !existente.get().getIdCategoria().equals(categoria.getIdCategoria())) {
            throw new IllegalArgumentException("Já existe uma categoria cadastrada com este nome.");
        }

        return repository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada para o ID: " + id));
    }

    public Categoria buscarPorNome(String nome) {
        return repository.findByNomeCategoria(nome)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com o nome: " + nome));
    }

    @Transactional
    public void deletar(Integer id) {
        Categoria categoria = buscarPorId(id);
        repository.delete(categoria);
    }
}