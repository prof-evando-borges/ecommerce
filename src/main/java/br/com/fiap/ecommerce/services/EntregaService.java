package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Transportadora;
import br.com.fiap.ecommerce.exceptions.EntregaException;
import br.com.fiap.ecommerce.entities.Entrega;
import br.com.fiap.ecommerce.exceptions.TransportadoraException;
import br.com.fiap.ecommerce.models.StatusEnum;
import br.com.fiap.ecommerce.repositories.EntregaRepository;
import br.com.fiap.ecommerce.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EntregaService {
    @Autowired
    private EntregaRepository repository;

    @Autowired
    private TransportadoraRepository transportadoraRepository;

    public void salvar(Entrega entrega){
        Entrega obj = repository.findById(entrega.getId()).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        repository.save(obj);
    }

    public List<Entrega> listarTodos(){
        List<Entrega> list = repository.findAll();
        return list;
    }

    public void atualizaTransportadora(UUID idTransportadora, UUID id){
        Entrega entrega = repository.findById(id).orElseThrow(()-> new EntregaException("Entrega não encontrado"));
        Transportadora transportadora = transportadoraRepository.findById(id).orElseThrow(()-> new TransportadoraException("Transportadora não encontrado"));
        entrega.setTransportadoraId(idTransportadora);
    }

    public void atualizarStatus(StatusEnum status, UUID Id) {
        Entrega obj = repository.findById(Id).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        obj.setStatus(status);
        repository.save(obj);
    }

    public Entrega buscarPorId(UUID id){
        Entrega obj = repository.findById(id).orElseThrow(()-> new EntregaException("entrega nao encontrada"));
        return obj;
    }

    public void deleteById(UUID id){
        Entrega obj = repository.findById(id).orElseThrow(() -> new EntregaException("Entrega não encontrada"));
        repository.deleteById(obj.getId());
    }

}
