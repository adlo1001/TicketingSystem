package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Address;

@Repository
public interface AddressService extends CrudRepository<Address, Integer> {

}
