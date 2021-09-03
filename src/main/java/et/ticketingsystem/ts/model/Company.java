package et.ticketingsystem.ts.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	private String companyName;

	@NotBlank
	private String companyLogo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(@NotBlank String companyName, @NotBlank String companyLogo, List<Address> addresses) {
		super();
		this.companyName = companyName;
		this.companyLogo = companyLogo;
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", companyLogo=" + companyLogo + ", addresses="
				+ addresses + ", getId()=" + getId() + ", getCompanyName()=" + getCompanyName() + ", getCompanyLogo()="
				+ getCompanyLogo() + ", getAddresses()=" + getAddresses() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
