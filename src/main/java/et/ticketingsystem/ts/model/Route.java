package et.ticketingsystem.ts.model;

import javax.persistence.*;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "routeName")
	private String routeName;

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL )
	private Station initialStation;

	@OneToOne(cascade = CascadeType.ALL )
	private Station subStation1;

	@OneToOne(cascade = CascadeType.ALL )
	private Station subStation2;

	@OneToOne(cascade = CascadeType.ALL )
	private Station subStation3;

	@OneToOne(cascade = CascadeType.ALL )
	private Station subStation4;

	@OneToOne(cascade = CascadeType.ALL )
	private Station subStation5;

	@OneToOne(cascade = CascadeType.ALL )
	private Station finalStation;

	public Route() {
		super();

	}

	public Route(String routeName, String description, Station initialStation, Station subStation1, Station subStation2,
			Station subStation3, Station subStation4, Station subStation5, Station finalStation) {
		super();
		this.routeName = routeName;
		this.description = description;
		this.initialStation = initialStation;
		this.subStation1 = subStation1;
		this.subStation2 = subStation2;
		this.subStation3 = subStation3;
		this.subStation4 = subStation4;
		this.subStation5 = subStation5;
		this.finalStation = finalStation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Station getInitialStation() {
		return initialStation;
	}

	public void setInitialStation(Station initialStation) {
		this.initialStation = initialStation;
	}

	public Station getSubStation1() {
		return subStation1;
	}

	public void setSubStation1(Station subStation1) {
		this.subStation1 = subStation1;
	}

	public Station getSubStation2() {
		return subStation2;
	}

	public void setSubStation2(Station subStation2) {
		this.subStation2 = subStation2;
	}

	public Station getSubStation3() {
		return subStation3;
	}

	public void setSubStation3(Station subStation3) {
		this.subStation3 = subStation3;
	}

	public Station getSubStation4() {
		return subStation4;
	}

	public void setSubStation4(Station subStation4) {
		this.subStation4 = subStation4;
	}

	public Station getSubStation5() {
		return subStation5;
	}

	public void setSubStation5(Station subStation5) {
		this.subStation5 = subStation5;
	}

	public Station getFinalStation() {
		return finalStation;
	}

	public void setFinalStation(Station finalStation) {
		this.finalStation = finalStation;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", routeName=" + routeName + ", description=" + description + ", initialStation="
				+ initialStation + ", subStation1=" + subStation1 + ", subStation2=" + subStation2 + ", subStation3="
				+ subStation3 + ", subStation4=" + subStation4 + ", subStation5=" + subStation5 + ", finalStation="
				+ finalStation + "]";
	}

}
