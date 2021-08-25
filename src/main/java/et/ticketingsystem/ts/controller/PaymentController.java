package et.ticketingsystem.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.model.Payment;
import et.ticketingsystem.ts.service.PaymentService;



@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/Payment")
	Iterable<Payment> read() {
		return paymentService.findAll();
	}

	@PostMapping("/Payment")
	Payment create(@RequestBody Payment payment) {
		return paymentService.save(payment);
	}

	@PutMapping("/Payment")
	Payment update(@RequestBody Payment payment) {
		return paymentService.save(payment);

	}

	@DeleteMapping("/Payement/{id}")
	void delete(@PathVariable int id) {
		paymentService.deleteById(id);
	}
}
