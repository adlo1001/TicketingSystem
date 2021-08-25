package et.ticketingsystem.ts.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Transportation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum TRAMODE {
		MINIBUS("MB"), BUS("BS"), TRAIN("TR"), PICKUP("PU"), SUV("SV"), SEDAN("SN"), SMALLCAR("SC");

		String code;

		private TRAMODE(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@Column(name = "vehicle")
	private String vehicle;

	@Column(name = "plateNumber")
	private String plateNumber;

	@Column(name = "owner") // name of the company
	private String owner;

	@Column(name = "numberOfSeat")
	private String numberOfSeat;

	private int transporationClass;

	@Enumerated(EnumType.STRING)
	private TRAMODE _mode;

	// @Embedded
	// private Payment paymentMode;

	private boolean isPetAllowed;
	private boolean isSmokingAllowed;
	private boolean isDrinkingAllowed;

	public Transportation() {
		// TODO Auto-generated constructor stub
	}

	public Transportation(String vehicle, String plateNumber, String owner, String numberOfSeat, int transporationClass,
			TRAMODE _mode, Payment paymentMode, boolean isPetAllowed, boolean isSmokingAllowed,
			boolean isDrinkingAllowed) {
		super();

		this.vehicle = vehicle;
		this.plateNumber = plateNumber;
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

	public String getplateNumber() {
		return plateNumber;
	}

	public void setplateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNumberOfSeat() {
		return numberOfSeat;
	}

	public void setNumberOfSeat(String numberOfSeat) {
		this.numberOfSeat = numberOfSeat;
	}

	@Override
	public String toString() {
		return "Transportation [id=" + id + ", vehicle=" + vehicle + ", plateNumber=" + plateNumber + ", owner=" + owner
				+ ", numberOfSeat=" + numberOfSeat + "]";
	}

}
