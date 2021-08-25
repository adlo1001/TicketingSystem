package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Ticket;

@Repository
public interface TicketingService extends CrudRepository<Ticket, Integer> {

	Iterable<Ticket> findByTicketNumber(String ticketNumber);
}
