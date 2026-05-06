 
package br.com.fiap.ecommerce.service;
 
import br.com.fiap.ecommerce.model.Cupom;

import br.com.fiap.ecommerce.repository.CupomRepository;

import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service[cite: 2]

public class CupomService {
 
    private final CupomRepository cupomRepository;
 
    public CupomService(CupomRepository cupomRepository) {

        this.cupomRepository = cupomRepository;

    }[cite: 2]
 
    public List<Cupom> listarTodos() {

        return cupomRepository.findAll();

    }[cite: 2]
 
    public Cupom salvar(Cupom cupom) {

        return cupomRepository.save(cupom);

    }[cite: 2]
 
    public void deletar(Long id) {

        cupomRepository.deleteById(id);

    }[cite: 2]

}
 