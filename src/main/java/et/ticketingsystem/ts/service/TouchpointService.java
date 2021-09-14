package et.ticketingsystem.ts.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Touchpoint;
@Repository
public interface TouchpointService extends CrudRepository<Touchpoint, Integer> {

}
