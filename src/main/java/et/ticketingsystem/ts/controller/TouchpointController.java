package et.ticketingsystem.ts.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Touchpoint;
import et.ticketingsystem.ts.service.TouchpointService;



@RestController
@RequestMapping(path = { "/touchpoints" })
public class TouchpointController {

	@Autowired
	TouchpointService touchPointService;

	@PostMapping("")
	public void create(@RequestBody Touchpoint Touchpoint) {
		touchPointService.save(Touchpoint);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Optional<Touchpoint> get(@PathVariable int id) {
		return touchPointService.findById(id);
	}

	@GetMapping(value = "", produces = "application/json")
	public Iterable<Touchpoint> getList() {
		return touchPointService.findAll();
	}

	@PutMapping(value = "", produces = "application/json")
	public void update(@RequestBody Touchpoint Touchpoint) {
		touchPointService.save(Touchpoint);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public void delete(@PathVariable int id) {
		touchPointService.deleteById(id);
	}

}
