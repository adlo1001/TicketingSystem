package et.ticketingsystem.ts.controller;

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
	Iterable<Ticket> read() {
		if (ticketService.count()!=0)
		return ticketService.findAll();
		else 
			throw new ErrorMessage("404","Ticket not found! ");
	}

	
	@GetMapping("/tickets/{id}")
	Optional<Ticket> read(@PathVariable int id) {
		if (ticketService.existsById(id))
		return ticketService.findById(id);
		else 
			throw new ErrorMessage("404",id+" -Ticket not found! ");
	}

	
	@PostMapping("/tickets")
	Ticket create(@RequestBody Ticket ticket) {
		return ticketService.save(ticket);
	}

	@PutMapping("/tickets")
	Ticket update(@RequestBody Ticket ticket) {
		
		return ticketService.save(ticket);

	}

	@DeleteMapping("/ticket/{id}")
	void delete(@PathVariable int id) {
		ticketService.deleteById(id);
	}

}
