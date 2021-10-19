package et.ticketingsystem.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Trip;
import et.ticketingsystem.ts.model.User;
import et.ticketingsystem.ts.service.TripService;

@RestController
//@RequestMapping(path = { "/trip" },produces = {"application/xml", "application/json"}, consumes = {"application/xml", "application/json"})
@RequestMapping(path= {"/trip"})
public class TripController {

	@Autowired
	TripService tripService;

	@GetMapping("/trips")
	public Iterable<Trip> read() {
		return tripService.findAll();
	}
    

	 
	@PostMapping("/trips")
	public void create(@RequestBody Trip trip) {
		 tripService.save(trip);
	}

	@PutMapping("/trips")
	public void  update(@RequestBody Trip trip) {
		 tripService.save(trip);
	}
	
	@DeleteMapping("/trips/{id}")
	public void delete(@PathVariable int id) {
		tripService.deleteById(id);
	}

	@DeleteMapping("/trips")
	public void deleteAll() {
		tripService.deleteAll();
	}
	
	
}
