package br.com.fiap.ecommerce.repositories;

import br.com.fiap.ecommerce.entities.Mensagem;
import br.com.fiap.ecommerce.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, UUID> {

    List<Mensagem> findByTicket(Ticket ticket);
}