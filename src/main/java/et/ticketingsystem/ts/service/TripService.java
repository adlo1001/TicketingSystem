package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Trip;

@Repository
public interface TripService extends CrudRepository<Trip, Integer> {

}
