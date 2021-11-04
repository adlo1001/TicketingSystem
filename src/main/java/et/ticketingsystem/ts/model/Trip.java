package et.ticketingsystem.ts.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private int id;
	
	
	public enum TRIPSTATUS {
		TICKETING, FULL, ONBOARDING, FINISHED, EXTENDED, CANCELLED;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private Transportation trans;

	@OneToOne
	private Route route;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TripPackage> tripPackage;

	@Future(message="Invalid Data Enter Future Date!")
	private Date initialTime;
	
    @Future(message="Invalid Data Enter Future Date!")
	private Date finalTime;
	
	@Digits(fraction = 1, integer = 2)
	private double tripPeriod;

	@Future(message="Invalid Data Enter Future Date!")
	private Date refreshmentBegin;
	
	
	@Future(message="Invalid Data Enter Future Date!")
	private Date refreshmentEnd;
	
	@Enumerated(EnumType.STRING)
	private TRIPSTATUS tripStatus;

	@Column(name = "transportationMode")
	private String transportationMode;

	@Column(name = "numberOfPassengers")
	private int numberOfPassenger;

	public Trip() {
		super();
	}

	
	public Trip(Transportation trans, Route route, List<TripPackage> tripPackage, @Future Date initialTime,
			@Future Date finalTime, @Digits(fraction = 1, integer = 2) double tripPeriod, @Future Date refreshmentBegin,
			@Future Date refreshmentEnd, TRIPSTATUS tripStatus, String transportationMode, int numberOfPassenger) {
		super();
		this.trans = trans;
		this.route = route;
		this.tripPackage = tripPackage;
		this.initialTime = initialTime;
		this.finalTime = finalTime;
		this.tripPeriod = tripPeriod;
		this.refreshmentBegin = refreshmentBegin;
		this.refreshmentEnd = refreshmentEnd;
		this.tripStatus = tripStatus;
		this.transportationMode = transportationMode;
		this.numberOfPassenger = numberOfPassenger;
	}


	public TRIPSTATUS getTripStatus() {
		return tripStatus;
	}


	public void setTripStatus(TRIPSTATUS tripStatus) {
		this.tripStatus = tripStatus;
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

	public List<TripPackage> getTripPackage() {
		return tripPackage;
	}

	public void setTripPackage(List<TripPackage> tripPackage) {
		this.tripPackage = tripPackage;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", trans=" + trans + ", route=" + route + ", initialTime=" + initialTime
				+ ", finalTime=" + finalTime + ", tripPeriod=" + tripPeriod + ", refreshmentBegin=" + refreshmentBegin
				+ ", refreshmentEnd=" + refreshmentEnd + ", transportationMode=" + transportationMode
				+ ", numberOfPassenger=" + numberOfPassenger + "]";
	}

}
