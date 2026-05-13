package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.exceptions.MensagemException;
import br.com.fiap.ecommerce.repositories.MensagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public Mensagem enviarMensagem(Mensagem mensagem) {
        return mensagemRepository.save(mensagem);
    }

    public Mensagem buscarPorId(UUID id) {
        return mensagemRepository.findById(id)
                .orElseThrow(() -> new MensagemException("Mensagem não encontrada com id: " + id));
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

    public void deletar(UUID id) {
        mensagemRepository.deleteById(id);
    }
}