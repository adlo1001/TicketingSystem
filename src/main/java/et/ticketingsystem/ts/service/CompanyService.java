package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Company;

@Repository
public interface CompanyService extends CrudRepository<Company, Integer> {

	
}
