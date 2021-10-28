package et.ticketingsystem.ts.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import et.ticketingsystem.ts.model.Passenger;

@Repository
@Transactional 
public interface PassengerService extends CrudRepository<Passenger, Integer> {

	Iterable<Passenger> findByFirstNameAndLastName(String firstName, String lastName);

	Iterable<Passenger> findByFirstName(String firstName);

	Iterable<Passenger> findByLastName(String lastName);
	
	
	@Modifying
	@Query(value="update passenger set _pay_const=UNIX_TIMESTAMP()*1000 , pay_date=NOW() where id =:id", nativeQuery=true)
	void updatePassengerStatus(@Param(value = "id") int id);
	 
	 //

}
