	package et.ticketingsystem.ts.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import et.ticketingsystem.ts.model.Ticket;

@Repository
@Transactional
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

	 //update ticket set status='VALID' where id (select * from passenger where UNIX_TIMESTAMP()*1000 - _book_cost >7200000 && pay_date is null )

	@Modifying
	@Query(value="update ticket set status='BOOKED' where id=:id ", nativeQuery=true)
	void updateTicketStatus(@Param("id") int id);
	
	@Modifying
	 @Query(value= "update ticket set status='PAID' where id in (select ticket_id from passenger where pay_date is  not null )",nativeQuery=true)
	 void updateTicketStatusValid();
	
	
	@Modifying
	@Query(value="update ticket set status='VALID' where id (select * from passenger where UNIX_TIMESTAMP()*1000 - _book_cost >7200000 && pay_date is null )", nativeQuery=true)
	void updateTicketStatusInvalid();
	

	
	
}
