package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.exceptions.TicketException;
import br.com.fiap.ecommerce.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private static final List<String> STATUS_VALIDOS = List.of("ABERTO", "EM_ANDAMENTO", "FECHADO");

    // Regra de negócio 1: status deve ser ABERTO, EM_ANDAMENTO ou FECHADO
    public Ticket criarTicket(Ticket ticket) {
        if (!STATUS_VALIDOS.contains(ticket.getStatus())) {
            throw new TicketException(
                    "Status inválido: '" + ticket.getStatus() + "'. Use: ABERTO, EM_ANDAMENTO ou FECHADO."
            );
        }
        return ticketRepository.save(ticket);
    }

    public Ticket buscarPorId(UUID id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketException("Ticket não encontrado com id: " + id));
    }

    public List<Ticket> buscarPorCliente(Cliente cliente) {
        return ticketRepository.findByCliente(cliente);
    }

    public List<Ticket> buscarPorStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    public Ticket atualizar(Ticket ticket) {
        if (!STATUS_VALIDOS.contains(ticket.getStatus())) {
            throw new TicketException(
                    "Status inválido: '" + ticket.getStatus() + "'. Use: ABERTO, EM_ANDAMENTO ou FECHADO."
            );
        }
        return ticketRepository.save(ticket);
    }

    // Regra de negócio 2: não pode deletar ticket com status EM_ANDAMENTO
    public void deletar(UUID id) {
        Ticket ticket = buscarPorId(id);
        if ("EM_ANDAMENTO".equals(ticket.getStatus())) {
            throw new TicketException(
                    "Não é possível excluir um ticket com status EM_ANDAMENTO."
            );
        }
        ticketRepository.deleteById(id);
    }

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }
}