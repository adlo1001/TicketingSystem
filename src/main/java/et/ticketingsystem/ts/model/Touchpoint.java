package et.ticketingsystem.ts.model;

import javax.persistence.*;

@Entity
public class Touchpoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum TOUCHPOINT {
		ANDROID, iPHONE, WEB;
	}

	@Enumerated(EnumType.STRING)
	private TOUCHPOINT touchPointName;

	public Touchpoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Touchpoint(TOUCHPOINT touchPointName) {
		super();
		this.touchPointName = touchPointName;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TOUCHPOINT getTouchPointName() {
		return touchPointName;
	}

	public void setTouchPointName(TOUCHPOINT touchPointName) {
		this.touchPointName = touchPointName;
	}

	@Override
	public String toString() {
		return "Touchpoint [id=" + id + ", touchPointName=" + touchPointName + "]";
	}

}
