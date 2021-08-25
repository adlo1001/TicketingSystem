    package et.ticketingsystem.ts.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum PASSENGERCLASS {
		ECONOMY("E"), BUSINUSS("B"), VIP("V");

		private String code;

		private PASSENGERCLASS(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}
	}

	public enum STATUS {
		SINGLE("S"), MULTIPLE("M");

		private String code;

		private STATUS(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

	}

	public enum GENDER {
		MALE("M"), FEMALE("F");

		private String code;

		private GENDER(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}
	}

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "lastName")
	private String lastName;

	private GENDER _gender;

	@Column(name = "age")
	private int age;

	private boolean isInfant;

	private boolean isChild;

	private boolean isTeen;

	private PASSENGERCLASS passengerCLASS;

	@Column(name = "disablity_status")
	private String disablity_status;

	private STATUS status;

	@OneToMany(cascade = CascadeType.ALL)
	@Embedded
	List<Address> addresses;

	@OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(unique = true)
	@Embedded
	List<Identification> identifications;

	public Passenger(int id, String firstName, String middleName, String lastName, GENDER _gender, int age,
			boolean isInfant, boolean isChild, boolean isTeen, PASSENGERCLASS passengerCLASS, String disablity_status,
			STATUS status, List<Address> addresses, List<Identification> identifications) {
		super();
		this.id = id;
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
		this.identifications = identifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getmiddleName() {
		return middleName;
	}

	public void setmiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public GENDER getGender() {
		return _gender;
	}

	public void setGender(GENDER gender) {
		this._gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisablity_status() {
		return disablity_status;
	}

	public void setDisablity_status(String disablity_status) {
		this.disablity_status = disablity_status;
	}

	public STATUS isStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public List<Address> getAddress() {
		return addresses;
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

	public PASSENGERCLASS getPassengerCLASS() {
		return passengerCLASS;
	}

	public void setPassengerCLASS(PASSENGERCLASS passengerCLASS) {
		this.passengerCLASS = passengerCLASS;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Identification> getIdentifications() {
		return identifications;
	}

	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}

	public void setAddress(List<Address> address) {
		this.addresses = address;
	}

	public GENDER get_gender() {
		return _gender;
	}

	public void set_gender(GENDER _gender) {
		this._gender = _gender;
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

	public STATUS getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", _gender=" + _gender + ", age=" + age + ", isInfant=" + isInfant + ", isChild=" + isChild
				+ ", isTeen=" + isTeen + ", passengerCLASS=" + passengerCLASS + ", disablity_status=" + disablity_status
				+ ", status=" + status + ", addresses=" + addresses + ", identifications=" + identifications + "]";
	}

}

    
