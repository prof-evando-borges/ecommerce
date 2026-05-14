package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.exceptions.MensagemException;
import br.com.fiap.ecommerce.exceptions.TicketException;
import br.com.fiap.ecommerce.repositories.MensagemRepository;
import br.com.fiap.ecommerce.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository mensagemRepository;
    private final TicketRepository ticketRepository;

    // Regra de negócio: não pode enviar mensagem para ticket FECHADO
    public Mensagem enviarMensagem(Mensagem mensagem) {
        Ticket ticket = ticketRepository.findById(mensagem.getTicket().getId())
                .orElseThrow(() -> new TicketException("Ticket não encontrado."));

        if ("FECHADO".equals(ticket.getStatus())) {
            throw new MensagemException(
                    "Não é possível enviar mensagens para um ticket com status FECHADO."
            );
        }
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