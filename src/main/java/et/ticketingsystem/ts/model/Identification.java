package et.ticketingsystem.ts.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Identification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "photo")
	private String photo;

	@Column(name = "attachment")
	private String attachment;

	@Column(name = "idType")
	private String idType;

	@Column(name = "idNumber")
	private String idNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	private Passenger passenger;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Identification(int id, String photo, String attachment, String idType, String idNumber) {
		super();
		this.id = id;
		this.photo = photo;
		this.attachment = attachment;
		this.idType = idType;
		this.idNumber = idNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getidType() {
		return idType;
	}

	public void setidType(String idType) {
		this.idType = idType;
	}

	public String getidNumber() {
		return idNumber;
	}

	public void setidNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Identification [id=" + id + ", photo=" + photo + ", attachment=" + attachment + ", idType=" + idType
				+ ", idNumber=" + idNumber + "]";
	}

}
