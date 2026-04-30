package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.repositories.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem enviarMensagem(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public Mensagem buscarPorId(Long id) {
        return mensagemRepository.findById(id).orElse(null);
    }

    public List<Mensagem> buscarPorTicket(Ticket ticket) {
        return mensagemRepository.findByTicket(ticket);
    }

    public List<Mensagem> listarTodas() {
        return mensagemRepository.findAll();
    }

    public Mensagem atualizar(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public void deletar(Long id) {
        mensagemRepository.deleteById(id);
    }
}