    package et.ticketingsystem.ts.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum PASSENGERCLASS {
		ECONOMY, BUSINUSS, VIP;

	}

	public enum STATUS {
		SINGLE, MULTIPLE;

	}

	public enum GENDER {
		MALE, FEMALE;

	}

	
	private String firstName;

	@NotBlank
	private String middleName;

	@NotBlank
	private String lastName;

	@Enumerated(EnumType.STRING)
	private GENDER _gender;

	private int age;

	private boolean isInfant;

	private boolean isChild;

	private boolean isTeen;

	@Enumerated(EnumType.STRING)
	private PASSENGERCLASS passengerCLASS;


	private String disablity_status;

	@Enumerated(EnumType.STRING)
	private STATUS status;

	@OneToMany(cascade = CascadeType.ALL)
	List<Address> addresses;

	@OneToOne(cascade = CascadeType.ALL)
	Identification _identifications;

	
	@OneToOne
	private Ticket ticket;
	
	public Passenger() {
		super();

	}




	public Passenger(String firstName, @NotBlank String middleName, @NotBlank String lastName, GENDER _gender, int age,
			boolean isInfant, boolean isChild, boolean isTeen, PASSENGERCLASS passengerCLASS, String disablity_status,
			STATUS status, List<Address> addresses, Identification _identifications, Ticket ticket) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this._gender = _gender;
		this.age = age;
		this.isInfant = isInfant;
		this.isChild = isChild;
		this.isTeen = isTeen;
		this.passengerCLASS = passengerCLASS;
		this.disablity_status = disablity_status;
		this.status = status;
		this.addresses = addresses;
		this._identifications = _identifications;
		this.ticket = ticket;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public GENDER get_gender() {
		return _gender;
	}


	public void set_gender(GENDER _gender) {
		this._gender = _gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isInfant() {
		return isInfant;
	}


	public void setInfant(boolean isInfant) {
		this.isInfant = isInfant;
	}


	public boolean isChild() {
		return isChild;
	}


	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}


	public boolean isTeen() {
		return isTeen;
	}


	public void setTeen(boolean isTeen) {
		this.isTeen = isTeen;
	}


	public PASSENGERCLASS getPassengerCLASS() {
		return passengerCLASS;
	}


	public void setPassengerCLASS(PASSENGERCLASS passengerCLASS) {
		this.passengerCLASS = passengerCLASS;
	}


	public String getDisablity_status() {
		return disablity_status;
	}


	public void setDisablity_status(String disablity_status) {
		this.disablity_status = disablity_status;
	}


	public STATUS getStatus() {
		return status;
	}


	public void setStatus(STATUS status) {
		this.status = status;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public Identification get_identifications() {
		return _identifications;
	}


	public void set_identifications(Identification _identifications) {
		this._identifications = _identifications;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", _gender=" + _gender + ", age=" + age + ", isInfant=" + isInfant + ", isChild=" + isChild
				+ ", isTeen=" + isTeen + ", passengerCLASS=" + passengerCLASS + ", disablity_status=" + disablity_status
				+ ", status=" + status + ", addresses=" + addresses + ", _identifications=" + _identifications
				+ ", ticket=" + ticket + "]";
	}


}

    
