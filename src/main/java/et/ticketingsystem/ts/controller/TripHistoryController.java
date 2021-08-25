package et.ticketingsystem.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import et.ticketingsystem.ts.model.TripHistory;
import et.ticketingsystem.ts.service.TripHistoryService;

@RequestMapping(path = { "/History" })
public class TripHistoryController {

	@Autowired
	TripHistoryService tripHistoryService;

	@GetMapping("/trpHist")
	Iterable<TripHistory> read() {
		return tripHistoryService.findAll();
	}

	@PostMapping("/trpHist")
	TripHistory create(@RequestBody TripHistory trpHist) {
		return tripHistoryService.save(trpHist);
	}

	@PutMapping("/trpHist")
	TripHistory update(@RequestBody TripHistory trpHist) {
		return tripHistoryService.save(trpHist);

	}

	@DeleteMapping("/trpHist/{id}")
	void delete(@PathVariable int id) {
		tripHistoryService.deleteById(id);
	}

}
