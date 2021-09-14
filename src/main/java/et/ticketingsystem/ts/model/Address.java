package et.ticketingsystem.ts.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Email
	private String email;

	@NotBlank
	private String phone1;

	private String phone2;

	private String phone3;

	private String houseNumber;

	@NotBlank
	private String streetAddress;

	@NotBlank
	private String city;

	@NotBlank
	private String country;


	public Address() {

	}

	public Address(@Email String email, @NotBlank String phone1, String phone2, String phone3, String houseNumber,
			String streetAddress, String city, String country) {
		super();
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.houseNumber = houseNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", email=" + email + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + ", houseNumber=" + houseNumber + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", country=" + country + "]";
	}

}
