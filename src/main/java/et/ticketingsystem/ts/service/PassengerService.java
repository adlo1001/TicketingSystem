package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Passenger;

@Repository
public interface PassengerService extends CrudRepository<Passenger, Integer> {

	Iterable<Passenger> findByFirstNameAndLastName(String first_name, String last_name);

	Iterable<Passenger> findByFirstName(String first_name);

	Iterable<Passenger> findByLastName(String last_name);

}
