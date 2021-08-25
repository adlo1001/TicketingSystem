package et.ticketingsystem.ts.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import et.ticketingsystem.ts.model.Touchpoint;

public interface TouchpointService extends CrudRepository<Touchpoint, Integer> {

}
