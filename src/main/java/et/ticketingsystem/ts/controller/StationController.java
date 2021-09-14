package et.ticketingsystem.ts.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import et.ticketingsystem.ts.model.Station;
import et.ticketingsystem.ts.service.StationService;

@RestController
public class StationController {

	@Autowired
	StationService stationService;

	@PostMapping("/stations")
	public void create(@Valid @RequestBody Station Station) {
		stationService.save(Station);

	}

	@GetMapping(value = "/stations/{stationName}", produces = "application/json")
	public Optional<Station> get(@PathVariable String stationName) {
		return stationService.findByStationName(stationName);
	}

	@GetMapping(value = "/stations", produces = "application/json")
	public Iterable<Station> getList() {
		return stationService.findAll();
	}

	@PutMapping(value = "/stations", produces = "application/json")
	public void update(@Valid @RequestBody Station Station) {
		stationService.save(Station);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public void delete(@PathVariable int id) {
		stationService.deleteById(id);
	}

	/*
	 * @GetMapping("/Station/search") public Iterable<Station>
	 * findByQuery(@RequestParam("stationName") String stationName) {
	 * 
	 * if (stationName != null) return
	 * stationService.findByStationName(stationName); else return
	 * stationService.findAll(); }
	 */
}
