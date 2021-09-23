package et.ticketingsystem.ts.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Company {
	@Id
	private int id;

	@NotBlank
	private String companyName;

	@NotBlank
	private String companyLogo;
	
	public Company() {
		super();
	}

	public Company(@NotBlank String companyName, @NotBlank String companyLogo, List<Address> addresses) {
		super();
		this.companyName = companyName;
		this.companyLogo = companyLogo;
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
	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", companyLogo=" + companyLogo + "]";
	}


}
