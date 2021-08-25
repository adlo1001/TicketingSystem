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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Passenger;
import et.ticketingsystem.ts.service.PassengerService;

@RestController
@RequestMapping(path = { "/Passenger" })
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@PostMapping("/add")
	public void create(@RequestBody Passenger passenger) {
		passengerService.save(passenger);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Optional<Passenger> get(@PathVariable int id) {
		return passengerService.findById(id);
	}

	@GetMapping(value = "/getPassengers", produces = "application/json")
	public Iterable<Passenger> getList() {
		return passengerService.findAll();
	}

	@PutMapping(value = "/Passenger", produces = "application/json")
	public void update(@RequestBody Passenger passenger) {
		passengerService.save(passenger);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public void delete(@PathVariable int id) {
		passengerService.deleteById(id);
	}

	@GetMapping("/Passenger/search")
	public Iterable<Passenger> findByQuery(@RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName) {
		if (firstName != null && lastName != null)
			return passengerService.findByFirstNameAndLastName(firstName, lastName);
		else if (firstName != null)
			return passengerService.findByFirstName(firstName);
		else if (lastName != null)
			return passengerService.findByLastName(lastName);
		else
			return passengerService.findAll();
	}

}
