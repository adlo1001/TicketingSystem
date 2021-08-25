package et.ticketingsystem.ts.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum _ROLE {
		ADMIN, USER, CUSTOMER
	}

	@Size(min = 6)
	@Column(unique=true)
	private String userId;

	@NotBlank
	private String password;

	@NotBlank
	private String firstName;

	@NotBlank
	private String middleName;

	@NotBlank
	private String lastName;

	@Enumerated(EnumType.ORDINAL)
	private _ROLE _role;

	@OneToMany(cascade = CascadeType.ALL)
	List<Address> addresses;

	@OneToMany(cascade = CascadeType.ALL)
	List<Identification> identification;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(@Size(min = 6) @NotBlank String userId, @NotBlank String password, @NotBlank String firstName,
			@NotBlank String middleName, String lastNameName, _ROLE _role, List<Address> addresses,
			List<Identification> identification) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastNameName;
		this._role = _role;
		this.addresses = addresses;
		this.identification = identification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public _ROLE get_role() {
		return _role;
	}

	public void set_role(_ROLE _role) {
		this._role = _role;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastNameName) {
		this.lastName = lastNameName;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastNameName=" + lastName + ", addresses=" + addresses + "]";
	}


}
