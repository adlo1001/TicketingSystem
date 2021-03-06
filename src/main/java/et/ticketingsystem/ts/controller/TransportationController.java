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

import et.ticketingsystem.ts.model.Passenger;
import et.ticketingsystem.ts.model.Transportation;
import et.ticketingsystem.ts.service.PassengerService;
import et.ticketingsystem.ts.service.TransportationService;

@RestController
public class TransportationController {
	@Autowired
	TransportationService transService;

	@PostMapping("/trans")
	public void create(@RequestBody Transportation trans) {
		transService.save(trans);
	}

	@GetMapping(value = "/trans/{id}", produces = "application/json")
	public Optional<Transportation> get(@PathVariable int id) {
		return transService.findById(id);
	}

	@GetMapping(value = "/trans", produces = "application/json")
	public Iterable<Transportation> getList() {
		return transService.findAll();
	}

	@PutMapping(value = "/trans", produces = "application/json")
	public void update(@RequestBody Transportation trans) {
		transService.save(trans);
	}

	@DeleteMapping(value = "/trans/delete/{id}", produces = "application/json")
	public void delete(@PathVariable int id) {
		transService.deleteById(id);
	}

}
