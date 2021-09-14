package et.ticketingsystem.ts.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trip{

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Transportation trans;

	@OneToOne
	private Route route;

	//@OneToMany(cascade = CascadeType.ALL)
	//private List<TripPackage> tripPackage;

	private Date initialTime;
	private Date finalTime;
	private double tripPeriod;

	private Date refreshmentBegin;
	private Date refreshmentEnd;

	@Column(name = "transportationMode")
	private String transportationMode;

	@Column(name = "numberOfPassengers")
	private int numberOfPassenger;

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trip(Station initialStation, Station finalStation, Date initialTime, Date finalTime, double tripPeriod,
			Date refreshmentBegin, Date refreshmentEnd, String transportationMode, int numberOfPassenger) {
		super();
		this.initialTime = initialTime;
		this.finalTime = finalTime;
		this.tripPeriod = tripPeriod;
		this.refreshmentBegin = refreshmentBegin;
		this.refreshmentEnd = refreshmentEnd;
		this.transportationMode = transportationMode;
		this.numberOfPassenger = numberOfPassenger;
	}

	public long getId() {
		return id;
	}


	public Date getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(Date initialTime) {
		this.initialTime = initialTime;
	}

	public Date getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Date finalTime) {
		this.finalTime = finalTime;
	}

	public double getTripPeriod() {
		return tripPeriod;
	}

	public void setTripPeriod(double tripPeriod) {
		this.tripPeriod = tripPeriod;
	}

	public Date getRefreshmentBegin() {
		return refreshmentBegin;
	}

	public void setRefreshmentBegin(Date refreshmentBegin) {
		this.refreshmentBegin = refreshmentBegin;
	}

	public Date getRefreshmentEnd() {
		return refreshmentEnd;
	}

	public void setRefreshmentEnd(Date refreshmentEnd) {
		this.refreshmentEnd = refreshmentEnd;
	}

	public String getTransportationMode() {
		return transportationMode;
	}

	public void setTransportationMode(String transportationMode) {
		this.transportationMode = transportationMode;
	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transportation getTrans() {
		return trans;
	}

	public void setTrans(Transportation trans) {
		this.trans = trans;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", trans="
				+ trans + ", route=" + route  + ", initialTime=" + initialTime
				+ ", finalTime=" + finalTime + ", tripPeriod=" + tripPeriod + ", refreshmentBegin=" + refreshmentBegin
				+ ", refreshmentEnd=" + refreshmentEnd + ", transportationMode=" + transportationMode
				+ ", numberOfPassenger=" + numberOfPassenger +  "]";
	}

}
