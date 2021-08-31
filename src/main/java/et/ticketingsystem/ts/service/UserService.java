package et.ticketingsystem.ts.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Passenger;
import et.ticketingsystem.ts.model.User;

@Repository
public interface UserService  extends CrudRepository<User, Integer>  {

	Iterable<User> findByFirstNameAndLastName(String first_name, String last_name);

	Iterable<User> findByFirstName(String first_name);

	Iterable<User> findByLastName(String last_name);

	Optional<User> findByUserId(String userId);

}
