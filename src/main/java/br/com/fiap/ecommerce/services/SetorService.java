package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Setor;
import br.com.fiap.ecommerce.repositories.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SetorService {
    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> listarSetores(){
        return setorRepository.findAll();
    }

    public Optional<Setor> consultarSetor(UUID id){
        return setorRepository.findById(id);
    }

    public void adicionarSetor(Setor setor){
        setorRepository.save(setor);
    }

    public void removerSetor(Setor setor){
        setorRepository.deleteById(setor.getId());
    }
}
