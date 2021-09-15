package et.ticketingsystem.ts.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Ticket;

@Repository
public interface TicketingService extends CrudRepository<Ticket, Integer> {

	Iterable<Ticket> findByTicketNumber(String ticketNumber);

	Iterable<Ticket> findByExpiryDate(Date expiryDate);

	@Query("select a from Ticket a where a.expiryDate >= :currentDate")
	List<Ticket> findByExpiryDateTimeBefore(@Param("currentDate") Date currentDate);

	@Query("select a from Ticket a ")
	List<Ticket> findByTotalTicketsForTrip (@Param("trip.id") String trip_id);
}
