package et.ticketingsystem.ts.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Transportation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum TRAMODE {
		MINIBUS, BUS, TRAIN, PICKUP, SUV, SEDAN, SMALLCAR;
	}

	private String vehicle;
    
	private String _plateNumber;

	@OneToOne
	private Company owner;

	@Column(name = "numberOfSeat")
	private int numberOfSeat;

	private int transporationClass;

	@Enumerated(EnumType.STRING)
	private TRAMODE _mode;

	// @Embedded
	// private Payment paymentMode;

	private boolean isPetAllowed;
	private boolean isSmokingAllowed;
	private boolean isDrinkingAllowed;

	public Transportation() {
		super();
	}

	public Transportation(String vehicle, String _plateNumber, Company owner, int numberOfSeat, int transporationClass,
			TRAMODE _mode, boolean isPetAllowed, boolean isSmokingAllowed, boolean isDrinkingAllowed, Trip trip) {
		super();
		this.vehicle = vehicle;
		this._plateNumber = _plateNumber;
		this.owner = owner;
		this.numberOfSeat = numberOfSeat;
		this.transporationClass = transporationClass;
		this._mode = _mode;
		this.isPetAllowed = isPetAllowed;
		this.isSmokingAllowed = isSmokingAllowed;
		this.isDrinkingAllowed = isDrinkingAllowed;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public Company getOwner() {
		return owner;
	}

	public void setOwner(Company owner) {
		this.owner = owner;
	}

	public int getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(int numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	public int getTransporationClass() {
		return transporationClass;
	}

	public void setTransporationClass(int transporationClass) {
		this.transporationClass = transporationClass;
	}

	public TRAMODE get_mode() {
		return _mode;
	}

	public void set_mode(TRAMODE _mode) {
		this._mode = _mode;
	}

	public boolean isPetAllowed() {
		return isPetAllowed;
	}

	public void setPetAllowed(boolean isPetAllowed) {
		this.isPetAllowed = isPetAllowed;
	}

	public boolean isSmokingAllowed() {
		return isSmokingAllowed;
	}

	public void setSmokingAllowed(boolean isSmokingAllowed) {
		this.isSmokingAllowed = isSmokingAllowed;
	}

	public boolean isDrinkingAllowed() {
		return isDrinkingAllowed;
	}

	public void setDrinkingAllowed(boolean isDrinkingAllowed) {
		this.isDrinkingAllowed = isDrinkingAllowed;
	}

	public String get_plateNumber() {
		return _plateNumber;
	}

	public void set_plateNumber(String _plateNumber) {
		this._plateNumber = _plateNumber;
	}

	@Override
	public String toString() {
		return "Transportation [id=" + id + ", vehicle=" + vehicle + ", plateNumber=" + _plateNumber + ", owner="
				+ owner + ", numberOfSeat=" + numberOfSeat + ", transporationClass=" + transporationClass + ", _mode="
				+ _mode + ", isPetAllowed=" + isPetAllowed + ", isSmokingAllowed=" + isSmokingAllowed
				+ ", isDrinkingAllowed=" + isDrinkingAllowed + "]";
	}

}
