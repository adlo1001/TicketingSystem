package et.ticketingsystem.ts.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import et.ticketingsystem.ts.model.Ticket;

@Repository
public interface TicketingService extends CrudRepository<Ticket, Integer> {

	Iterable<Ticket> findByTicketNumber(String ticketNumber);

	Iterable<Ticket> findByExpiryDate(Date expiryDate);

	@Query("select a from Ticket a where a.expiryDate >= :currentDate")
	List<Ticket> findByExpiryDateTimeBefore(@Param("currentDate") Date currentDate);

	@Query("select a from Ticket a ")
	List<Ticket> findByTotalTicketsForTrip (@Param("trip.id") String trip_id);
	
	
	@Query(value="select * from \r\n" + 
			"(\r\n" + 
			"select * from ticket where trip_id in (\r\n" + 
			"select id from trip where route_id in (\r\n" + 
			"select id from route \r\n" + 
			"where initial_station_id in ( select id from station where city like  :initial_station  || station_name like   :initial_station  ) )\r\n" + 
			"and initial_time>' 2021-10-18 15:00:00') and status='BOOKED') a ,\r\n" + 
			"\r\n" + 
			"(select * from ticket where trip_id in (\r\n" + 
			"select id from trip where route_id in (\r\n" + 
			"select id from route \r\n" + 
			"where  final_station_id in ( select id from station where station_name like :final_station	 ) ||\r\n" + 
			"sub_station1_id in ( select id from station where station_name like :final_station	) || sub_station2_id in ( select id from station where station_name like :final_station)||\r\n" + 
			"sub_station3_id in ( select id from station where station_name like :final_station	) || sub_station4_id in ( select id from station where station_name like :final_station	)||\r\n" + 
			"sub_station5_id in ( select id from station where station_name like :final_station	)) and initial_time >=:initial_time) and status='BOOKED' ) b\r\n" + 
			"where a.id=b.id",nativeQuery=true)
	  List<Ticket> findByIntialAndFinal(@Param("initial_station") String initial_station, @Param("final_station") String final_station, @Param("initial_time") String initial_time);    

	/*
	@Query(value="select * from \r\n" + 
			"(\r\n" + 
			"select * from ticket where trip_id in (\r\n" + 
			"select id from trip where route_id in (\r\n" + 
			"select id from route \r\n" + 
			"where initial_station_id in ( select id from station where city like '%Megenagna near Lem Hotel%' || station_name like  '%Megenagna%' ) )\r\n" + 
			"and initial_time>' 2021-10-18 15:00:00') and status='BOOKED') a ,\r\n" + 
			"\r\n" + 
			"(select * from ticket where trip_id in (\r\n" + 
			"select id from trip where route_id in (\r\n" + 
			"select id from route \r\n" + 
			"where initial_station_id in ( select id from station where station_name like '%alaba%') || final_station_id in ( select id from station where station_name like '%alaba%') ||\r\n" + 
			"sub_station1_id in ( select id from station where station_name like '%alaba%') || sub_station2_id in ( select id from station where station_name like '%alaba%')||\r\n" + 
			"sub_station3_id in ( select id from station where station_name like '%alaba%') || sub_station4_id in ( select id from station where station_name like '%alaba%')||\r\n" + 
			"sub_station5_id in ( select id from station where station_name like '%alaba%')) and initial_time>' 2021-10-18 15:00:00') and status='BOOKED' ) b\r\n" + 
			"where a.id=b.id",nativeQuery=true)
	List<Ticket> findByIntialAndFinal(@Param("station.station_name") String initial_station, @Param("station.station_name") String final_station, @Param("trip.initial_time") String initial_time);    

*/
}
