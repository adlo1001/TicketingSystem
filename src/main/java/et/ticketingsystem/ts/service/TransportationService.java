package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Transportation;

@Repository
public interface TransportationService extends CrudRepository<Transportation, Integer> {

}
