package et.ticketingsystem.ts.model;

import javax.persistence.*;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum CHANNEL {
		BANK, MOBILEBANKING, INTERNETBANKING, SMS, CASH, WALLET, OTHER;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(CHANNEL paymentMode) {
		super();
		this.paymentMode = paymentMode;
	}



	public CHANNEL getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(CHANNEL paymentMode) {
		this.paymentMode = paymentMode;
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
