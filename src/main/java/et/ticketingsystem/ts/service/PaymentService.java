package et.ticketingsystem.ts.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import et.ticketingsystem.ts.model.Payment;
import et.ticketingsystem.ts.model.Payment.CHANNEL;

public interface PaymentService extends CrudRepository<Payment, Integer> {

	Iterable<Payment> findByPaymentMode(CHANNEL ch);
}
