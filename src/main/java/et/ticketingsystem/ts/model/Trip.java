package et.ticketingsystem.ts.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private int id;

	@OneToOne
	@Embedded
	private Station initialStation;

	@OneToOne
	@Embedded
	private Station finalStation;

	@OneToOne
	@Embedded
	private Transportation trans;

	@OneToOne
	@Embedded
	private Route route;

	@OneToMany(cascade = CascadeType.ALL)
	@Embedded
	private List<TripPackage> tripPackage;

	private Date initialTime;
	private Date finalTime;
	private double tripPeriod;

	private Date refreshmentBegin;
	private Date refreshmentEnd;

	@Column(name = "transportationMode")
	private String transportationMode;

	@Column(name = "numberOfPassengers")
	private int numberOfPassenger;

	@OneToOne(fetch = FetchType.LAZY)
	private TripHistory history;

	public Trip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trip(Station initialStation, Station finalStation, Date initialTime, Date finalTime, double tripPeriod,
			Date refreshmentBegin, Date refreshmentEnd, String transportationMode, int numberOfPassenger) {
		super();
		this.initialStation = initialStation;
		this.finalStation = finalStation;
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

	public Station getInitialStation() {
		return initialStation;
	}

	public void setInitialStation(Station initialStation) {
		this.initialStation = initialStation;
	}

	public Station getFinalStation() {
		return finalStation;
	}

	public void setFinalStation(Station finalStation) {
		this.finalStation = finalStation;
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

	public List<TripPackage> getTripPackage() {
		return tripPackage;
	}

	public void setTripPackage(List<TripPackage> tripPackage) {
		this.tripPackage = tripPackage;
	}

	public TripHistory getHistory() {
		return history;
	}

	public void setHistory(TripHistory history) {
		this.history = history;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", initialStation=" + initialStation + ", finalStation=" + finalStation + ", trans="
				+ trans + ", route=" + route + ", tripPackage=" + tripPackage + ", initialTime=" + initialTime
				+ ", finalTime=" + finalTime + ", tripPeriod=" + tripPeriod + ", refreshmentBegin=" + refreshmentBegin
				+ ", refreshmentEnd=" + refreshmentEnd + ", transportationMode=" + transportationMode
				+ ", numberOfPassenger=" + numberOfPassenger + ", history=" + history + "]";
	}

}
