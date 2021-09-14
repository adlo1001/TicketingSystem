package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.TripPackage;

@Repository
public interface TripPackageService extends CrudRepository<TripPackage, Integer> {

}
