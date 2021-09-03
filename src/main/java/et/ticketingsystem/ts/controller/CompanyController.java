package et.ticketingsystem.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Company;
import et.ticketingsystem.ts.model.Route;
import et.ticketingsystem.ts.service.CompanyService;
import et.ticketingsystem.ts.service.RouteService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/company")
	Iterable<Company> read() {
		return companyService.findAll();
	}

	@PostMapping("/company")
	Company create(@RequestBody Company company) {
		return companyService.save(company);
	}

	@PutMapping("/company")
	Company update(@RequestBody Company company) {
		return companyService.save(company);
	}
	@DeleteMapping("/company/{id}")
	void delete(@PathVariable int id) {
		companyService.deleteById(id);
	}

}
