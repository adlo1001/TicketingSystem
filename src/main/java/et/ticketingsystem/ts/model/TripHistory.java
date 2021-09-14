package et.ticketingsystem.ts.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TripHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@OneToOne(cascade=CascadeType.ALL)
	private Trip trip;
	
	
	public TripHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripHistory(Trip trip, Date tripDate) {
		super();
		this.trip = trip;
		this.tripDate = tripDate;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public Date tripDate;

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	@Override
	public String toString() {
		return "TripHistory [id=" + id + ", trip=" + trip + ", tripDate=" + tripDate + "]";
	}

}
