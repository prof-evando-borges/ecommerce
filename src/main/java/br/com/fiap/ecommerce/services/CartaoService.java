 
package br.com.fiap.ecommerce.service;
 
import br.com.fiap.ecommerce.model.Cartao;

import br.com.fiap.ecommerce.repository.CartaoRepository;

import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service[cite: 2]

public class CartaoService {
 
    private final CartaoRepository cartaoRepository;
 
    public CartaoService(CartaoRepository cartaoRepository) {

        this.cartaoRepository = cartaoRepository;

    }[cite: 2]
 
    public List<Cartao> listarTodos() {

        return cartaoRepository.findAll();

    }[cite: 2]
 
    public Cartao salvar(Cartao cartao) {

        return cartaoRepository.save(cartao);

    }[cite: 2]
 
    public void deletar(Long id) {

        cartaoRepository.deleteById(id);

    }[cite: 2]

}
 