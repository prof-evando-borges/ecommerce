package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.exceptions.TransportadoraException;
import br.com.fiap.ecommerce.models.Transportadora;
import br.com.fiap.ecommerce.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {
    @Autowired
    private TransportadoraRepository repository;

    public void salvar(Transportadora transportadora){
        Transportadora obj = repository.findById(transportadora.getId()).orElseThrow(() -> new TransportadoraException("Transportadora não encontrada"));
        repository.save(obj);
    }

    public List<Transportadora> listarTodos(){
        List<Transportadora> list = repository.findAll();
        return list;
    }

    public void buscarPorId(Long Id){
        Transportadora obj = repository.findById(Id).orElseThrow(() -> new TransportadoraException("Transportadora não encontrada"));
        repository.save(obj);
    }
}
