package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> listarTodos() {
        return ticketService.listarTodos();
    }

    @GetMapping("/{id}")
    public Ticket buscarPorId(@PathVariable Long id) {
        return ticketService.buscarPorId(id);
    }

    @PostMapping
    public Ticket criarTicket(@RequestBody @Valid Ticket ticket) {
        return ticketService.criarTicket(ticket);
    }

    @PutMapping
    public Ticket atualizar(@RequestBody @Valid Ticket ticket) {
        return ticketService.atualizar(ticket);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        ticketService.deletar(id);
    }
}