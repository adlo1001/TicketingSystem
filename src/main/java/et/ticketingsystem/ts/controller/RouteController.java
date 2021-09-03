package et.ticketingsystem.ts.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import et.ticketingsystem.ts.model.Route;
import et.ticketingsystem.ts.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@RestController
public class RouteController {

	@Autowired
	RouteService routeService;

	@GetMapping("/routes")
	Iterable<Route> read() {
		return routeService.findAll();
	}

	@PostMapping("/routes")
	Route create(@RequestBody Route route) {
		return routeService.save(route);
	}

	@PutMapping("/routes")
	Route update(@RequestBody Route route) {
		return routeService.save(route);
	}
	@DeleteMapping("/routes/{id}")
	void delete(@PathVariable int id) {
		routeService.deleteById(id);
	}
	
	@DeleteMapping("/routes")
	void delete() {
		routeService.deleteAll();
	}

}
