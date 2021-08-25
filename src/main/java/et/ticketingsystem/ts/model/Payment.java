package et.ticketingsystem.ts.model;

import javax.persistence.*;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum CHANNEL {
		MOBILEBANKING("M"), INTERNETBANKING("I"), SMS("S"), CASH("C"), WALLET("W"), OTHER("O");

		String code;

		private CHANNEL(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	// @Enumerated(EnumType.STRING)
	private CHANNEL paymentMode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
