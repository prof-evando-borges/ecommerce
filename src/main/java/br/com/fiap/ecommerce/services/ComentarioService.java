package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Comentario;
import br.com.fiap.ecommerce.entities.Produto;
import br.com.fiap.ecommerce.repository.ClienteRepository;
import br.com.fiap.ecommerce.repository.ComentarioRepository;
import br.com.fiap.ecommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             ProdutoRepository produtoRepository,
                             ClienteRepository clienteRepository) {
        this.comentarioRepository = comentarioRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Comentario criar(Long produtoId, Long clienteId, String texto) {

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setProduto(produto);
        comentario.setCliente(cliente);
        comentario.setComentario(texto);

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listar() {
        return comentarioRepository.findAll();
    }

    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public void deletar(Long id) {
        comentarioRepository.deleteById(id);
    }
}
