package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Passenger;

@Repository
public interface PassengerService extends CrudRepository<Passenger, Integer> {

	Iterable<Passenger> findByFirstNameAndLastName(String firstName, String lastName);

	Iterable<Passenger> findByFirstName(String firstName);

	Iterable<Passenger> findByLastName(String lastName);

}
