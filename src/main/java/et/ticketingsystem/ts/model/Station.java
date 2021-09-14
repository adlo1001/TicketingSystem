package et.ticketingsystem.ts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	private String stationName;

	@NotBlank
	private String city;

	@NotBlank
	private String region;

	private String province;

	private String subcity;

	private String description;

	public Station() {
		super();
	}

	public Station(@NotBlank String stationName, @NotBlank String city, @NotBlank String region, String province,
			String subcity, String description) {
		super();
		this.stationName = stationName;
		this.city = city;
		this.region = region;
		this.province = province;
		this.subcity = subcity;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSubcity() {
		return subcity;
	}

	public void setSubcity(String subcity) {
		this.subcity = subcity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvice() {
		return province;
	}

	public void setProvice(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", stationName=" + stationName + ", city=" + city + ", region=" + region
				+ ", province=" + province + ", subcity=" + subcity + ", description=" + description + "]";
	}


}
