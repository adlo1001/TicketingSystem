package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;

import et.ticketingsystem.ts.model.TripPackage;

public interface TripPackageService extends CrudRepository<TripPackage, Integer> {

}
