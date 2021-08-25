package et.ticketingsystem.ts.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.TripHistory;

@Repository
public interface TripHistoryService extends CrudRepository<TripHistory, Integer> {

}
