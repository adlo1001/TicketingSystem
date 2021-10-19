package et.ticketingsystem.ts.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Ticket;
import et.ticketingsystem.ts.model.Trip;
import et.ticketingsystem.ts.service.TicketingService;
import et.ticketingsystem.ts.util.ErrorMessage;

@RestController
public class TicketController {

	@Autowired
	TicketingService ticketService;
	String pattern = "yyyy-M-dd hh:mm:ss";
	//String pattern2 = "EEE MMM d yyyy HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	//SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
	String test ="Wed Oct 27 2021 09:53:00";

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

		String date = simpleDateFormat.format(new Date());
		Date issueDate = new Date();
		
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

	@GetMapping("/ticketsQuery/")
	public Iterable<Ticket> InitialAndFinal
	( @RequestParam Map<String, String> queryString
			/*@PathVariable String _initial,@PathVariable String _final, @PathVariable String _boarding_time*/) throws ParseException {
		String _initial=queryString.get("_initial");
		String _final=queryString.get("_final");
		String _boarding_time = simpleDateFormat.format(simpleDateFormat.parse(queryString.get("_boarding_time")));
		//System.out.println("----------------------------------------------->:"+ simpleDateFormat.format(simpleDateFormat2.parse(test)));
		
		Iterable<Ticket> _lists= ticketService.findByIntialAndFinal("%"+_initial+"%", "%"+_final+"%", _boarding_time);
		if(ticketService.count()!=0)
			return _lists;
		else 
			throw new ErrorMessage("404","Ticket not found");

	}

	

	
	
	@PostMapping("/tickets")
	public void  create(@RequestBody Ticket ticket) {
		ticketService.save(ticket);
	}

	@PutMapping("/tickets")
	public void  update(@RequestBody Ticket ticket) {
		 ticketService.save(ticket);

	}

	@DeleteMapping("/tickets/{id}")
	public void delete(@PathVariable int id) {
		ticketService.deleteById(id);
	}

	@DeleteMapping("/tickets")
	public void delete() {
		ticketService.deleteAll();
	}

}
