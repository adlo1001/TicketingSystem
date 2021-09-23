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

	@GetMapping("/payments")
	public Iterable<Payment> read() {
		return paymentService.findAll();
	}

	@PostMapping("/payments")
	public void  create(@RequestBody Payment payment) {
		paymentService.save(payment);
	}

	@PutMapping("/payments")
	public void  update(@RequestBody Payment payment) {
		 paymentService.save(payment);

	}
	@DeleteMapping("/payments/{id}")
	public void  remove(@PathVariable int id ) {
		 paymentService.deleteById(id);

	}

	@DeleteMapping("/payements/{id}")
	public void removeAll() {
		paymentService.deleteAll();
	}
}
