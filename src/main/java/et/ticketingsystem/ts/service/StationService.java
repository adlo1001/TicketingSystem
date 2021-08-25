package et.ticketingsystem.ts.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Station;

@Repository
public interface StationService extends CrudRepository<Station, Integer> {

	Optional<Station> findByStationName(String stationName);
}
