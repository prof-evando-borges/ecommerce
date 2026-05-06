package br.com.fiap.ecommerce.services;

import br.com.fiap.ecommerce.entities.Cliente;
import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket criarTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket salvar(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket buscarPorId(Long id) {
        return ticketRepository.findById(id).orElse(null);
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

    public void deletar(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }

    public Ticket abrirTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket atualizarStatusTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarTicketsPorStatus(String status) {
        return ticketRepository.findByStatus(status);
    }
}