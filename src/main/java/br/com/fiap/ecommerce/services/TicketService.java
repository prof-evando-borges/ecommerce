package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.exceptions.TicketException;
import br.com.fiap.ecommerce.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket criarTicket(Ticket ticket) {
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
        return ticketRepository.save(ticket);
    }

    public void deletar(UUID id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }
}