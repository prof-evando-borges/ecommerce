package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.exceptions.TransportadoraException;
import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransportadoraService {
    @Autowired
    private TransportadoraRepository repository;

    public void criar(Transportadora transportadora){
        repository.save(transportadora);
    }

    public void atualizar(Transportadora transportadora, UUID id){
        Transportadora obj = repository.findById(id).orElseThrow(() -> new TransportadoraException("Transportadora não encontrada"));
        repository.save(obj);
    }

    public List<Transportadora> listarTodos(){
        List<Transportadora> list = repository.findAll();
        return list;
    }

    public Transportadora buscarPorId(UUID Id){
        Transportadora obj = repository.findById(Id).orElseThrow(() -> new TransportadoraException("Transportadora não encontrada"));
        return obj;
    }

    public void deleteById(UUID id){
        Transportadora obj = repository.findById(id).orElseThrow(() -> new TransportadoraException("Transportadora não encontrada"));
        repository.deleteById(obj.getId());
    }
}
