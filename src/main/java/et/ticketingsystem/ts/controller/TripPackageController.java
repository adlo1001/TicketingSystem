package et.ticketingsystem.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Trip;
import et.ticketingsystem.ts.model.TripPackage;
import et.ticketingsystem.ts.service.TripPackageService;
import et.ticketingsystem.ts.service.TripService;

@RestController
@RequestMapping(path= {"/trips"})
public class TripPackageController {

	@Autowired
	TripPackageService tripPackageService;

	@GetMapping("/packages")
	public Iterable<TripPackage> read() {
		return tripPackageService.findAll();
	}

	@PostMapping("/packages")
	public void create(@RequestBody TripPackage trip_package) {
		 tripPackageService.save(trip_package);
	}

	@PutMapping("/packages")
	public void update(@RequestBody TripPackage trip_package) {
		tripPackageService.save(trip_package);

	}

	@DeleteMapping("/packages/{id}")
	public void delete(@PathVariable int id) {
		tripPackageService.deleteById(id);
	}

	@DeleteMapping("/packages")
	public void delete() {
		tripPackageService.deleteAll();
	}

}
