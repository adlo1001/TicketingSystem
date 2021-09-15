package et.ticketingsystem.ts.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Ticket;
import et.ticketingsystem.ts.model.Trip;
import et.ticketingsystem.ts.service.TicketingService;
import et.ticketingsystem.ts.util.ErrorMessage;

@RestController
public class TicketController {

	@Autowired
	TicketingService ticketService;

	@GetMapping("/tickets")
	public Iterable<Ticket> readAll() {
		if (ticketService.count()!=0)
		return ticketService.findAll();
		else 
			throw new ErrorMessage("404","Ticket not found! ");
	}
   
	@GetMapping("/ticketsValid")
	public Iterable<Ticket> readValid() {
		
		String pattern = "yyyy-MM-dd";
		//String pattern = "yyyy-MM-DDTHH";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		Date expiryDate = new Date();
	
		if (ticketService.count()!=0)
		   return ticketService.findByExpiryDateTimeBefore(expiryDate);
		else 
			throw new ErrorMessage("404","Ticket not found! ");
	}

	@GetMapping("/ticketsByIssueDate")
	public Iterable<Ticket> readByIssue() {
		//String pattern = "yyyy-MM-dd";
		String pattern = "yyyy-MM-DDTHH";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		Date issueDate = new Date();
		
		System.out.println("System Date:"+ issueDate);
		if (ticketService.count()!=0)
			
		   return ticketService.findByExpiryDate(issueDate);
		else 
			throw new ErrorMessage("404","Ticket not found! ");
	}

	
	@GetMapping("/ticketsByTrip/{trip_id}")
	public Iterable<Ticket> readByTickets(@PathVariable String trip_id) {
		if (ticketService.count()!=0)
		   return ticketService.findByTotalTicketsForTrip( trip_id);
		else 
			throw new ErrorMessage("404","Ticket not found! ");
	}

	@GetMapping("/tickets/{id}")
	public Optional<Ticket> read(@PathVariable int id) {
		if (ticketService.existsById(id))
		return ticketService.findById(id);
		else 
			throw new ErrorMessage("404",id+" -Ticket not found! ");
	}

	
	
	
	@PostMapping("/tickets")
	public void  create(@RequestBody Ticket ticket) {
		ticketService.save(ticket);
	}

	@PutMapping("/tickets")
	public void  update(@RequestBody Ticket ticket) {
		 ticketService.save(ticket);

	}

	@DeleteMapping("/ticket/{id}")
	public void delete(@PathVariable int id) {
		ticketService.deleteById(id);
	}

}
