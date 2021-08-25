package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Identification;

@Repository
public interface IdentificationService extends CrudRepository<Identification, Integer> {

}
