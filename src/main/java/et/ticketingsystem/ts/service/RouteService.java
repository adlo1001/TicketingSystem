package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Route;

@Repository
public interface RouteService extends CrudRepository<Route, Integer> {

}
