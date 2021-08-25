package et.ticketingsystem.ts.model;

import javax.persistence.*;

@Entity
public class Touchpoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum TOUCHPOINT {
		ANDROID("A"), iPHONE("I"), WEB("W");

		String code;

		private TOUCHPOINT(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@Enumerated(EnumType.STRING)
	private TOUCHPOINT touchPointName;

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

}
