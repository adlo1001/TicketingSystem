package et.ticketingsystem.ts.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public enum TICKET_STATUS {
		VALID("VA"), PAID("PA"), BOOKED("BO"), EXPIRED("EX"), EXTENEDED("ET"), CONSUMED("CO"), INVALID("IN"),
		PENDING("PN");

		String code;

		private TICKET_STATUS(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@NotBlank
	@Column(name = "ticketNumber")
	private String ticketNumber;

	@NotBlank
	@Column(name = "refNumber")
	private String refNumber;

	@NotNull
	@Min(value = 1)
	private int numberOfAdults;

	private int numberOfKids;

	private int numberOfInfants;

	@NotNull
	private int numberOfDisabled;

	@NotNull(message = "Please enter issue Date!")
	@Column(name = "issueDate")
	private Date issueDate;

	@NotNull(message = "Please enter expiry Date!")
	@Column(name = "expiry_date")
	private Date expiry_date;

	@Enumerated(EnumType.STRING)
	private TICKET_STATUS status;

	@NotNull
	private double grossPriceAmnt;

	@NotNull
	private double taxesAmnt;

	@NotNull
	private double otherAmnt;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticket(@NotBlank String ticketNumber, @NotBlank String refNumber, @NotNull @Min(1) int numberOfAdults,
			int numberOfKids, int numberOfInfants, @NotNull int numberOfDisabled,
			@NotNull(message = "Please enter issue Date!") Date issue_date,
			@NotNull(message = "Please enter expiry Date!") Date expiry_date, TICKET_STATUS status,
			@NotNull Date issueDate, @NotNull double grossPriceAmnt, @NotNull double taxesAmnt,
			@NotNull double otherAmnt) {
		super();
		this.ticketNumber = ticketNumber;
		this.refNumber = refNumber;
		this.numberOfAdults = numberOfAdults;
		this.numberOfKids = numberOfKids;
		this.numberOfInfants = numberOfInfants;
		this.numberOfDisabled = numberOfDisabled;
		this.expiry_date = expiry_date;
		this.status = status;
		this.issueDate = issueDate;
		this.grossPriceAmnt = grossPriceAmnt;
		this.taxesAmnt = taxesAmnt;
		this.otherAmnt = otherAmnt;
	}

	@NotNull
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getticketNumber() {
		return ticketNumber;
	}

	public void setticketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public Date getissueDate() {
		return issueDate;
	}

	public void setissueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getNumberOfKids() {
		return numberOfKids;
	}

	public void setNumberOfKids(int numberOfKids) {
		this.numberOfKids = numberOfKids;
	}

	public int getNumberOfInfants() {
		return numberOfInfants;
	}

	public void setNumberOfInfants(int numberOfInfants) {
		this.numberOfInfants = numberOfInfants;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public double getGrossPriceAmnt() {
		return grossPriceAmnt;
	}

	public void setGrossPriceAmnt(double grossPriceAmnt) {
		this.grossPriceAmnt = grossPriceAmnt;
	}

	public double getTaxesAmnt() {
		return taxesAmnt;
	}

	public void setTaxesAmnt(double taxesAmnt) {
		this.taxesAmnt = taxesAmnt;
	}

	public double getOtherAmnt() {
		return otherAmnt;
	}

	public void setOtherAmnt(double otherAmnt) {
		this.otherAmnt = otherAmnt;
	}

	public int getNumberOfDisabled() {
		return numberOfDisabled;
	}

	public void setNumberOfDisabled(int numberOfDisabled) {
		this.numberOfDisabled = numberOfDisabled;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public TICKET_STATUS getStatus() {
		return status;
	}

	public void setStatus(TICKET_STATUS status) {
		this.status = status;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketNumber=" + ticketNumber + ", refNumber=" + refNumber + ", numberOfAdults="
				+ numberOfAdults + ", numberOfKids=" + numberOfKids + ", numberOfInfants=" + numberOfInfants
				+ ", numberOfDisabled=" + numberOfDisabled + ", expiry_date=" + expiry_date + ", status=" + status
				+ ", issueDate=" + issueDate + ", grossPriceAmnt=" + grossPriceAmnt + ", taxesAmnt=" + taxesAmnt
				+ ", otherAmnt=" + otherAmnt + "]";
	}

}
