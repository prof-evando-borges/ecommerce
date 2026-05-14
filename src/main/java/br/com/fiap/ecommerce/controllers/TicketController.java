package br.com.fiap.ecommerce.controllers;

import br.com.fiap.ecommerce.entities.Ticket;
import br.com.fiap.ecommerce.services.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> listarTodos() {
        return ResponseEntity.ok(ticketService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(ticketService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ticket> criarTicket(@RequestBody @Valid Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.criarTicket(ticket));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> atualizar(@PathVariable String id, @RequestBody @Valid Ticket ticket) {
        ticket.setId(id);
        return ResponseEntity.ok(ticketService.atualizar(ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        ticketService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}