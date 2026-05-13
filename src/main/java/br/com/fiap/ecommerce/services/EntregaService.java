package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.exceptions.EntregaException;
import br.com.fiap.ecommerce.entities.Entrega;
import br.com.fiap.ecommerce.exceptions.TransportadoraException;
import br.com.fiap.ecommerce.models.StatusEnum;
import br.com.fiap.ecommerce.repositories.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository repository;

    public void salvar(Entrega entrega){
        Entrega obj = repository.findById(entrega.getId()).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        repository.save(obj);
    }

    public List<Entrega> listarTodos(){
        List<Entrega> list = repository.findAll();
        return list;
    }

    public void atualizarStatus(StatusEnum status, Long Id) {
        Entrega obj = repository.findById(Id).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        obj.setStatus(status);
        repository.save(obj);
    }

    public Entrega buscarPorId(Long id){
        Entrega obj = repository.findById(id).orElseThrow(()-> new EntregaException("entrega nao encontrada"));
        return obj;
    }

    public void deleteById(Long id){
        Entrega obj = repository.findById(id).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        repository.deleteById(obj.getId());
    }

}