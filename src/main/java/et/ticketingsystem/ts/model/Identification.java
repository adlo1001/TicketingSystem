package et.ticketingsystem.ts.model;

import javax.persistence.CascadeType;
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

	private String photo;

	private String attachment;

	private String identificationType;

	private String identificationNumber;

	public Identification() {
		super();

	}


	public Identification(String photo, String attachment, String identificationType, String identificationNumber) {
		super();
		this.photo = photo;
		this.attachment = attachment;
		this.identificationType = identificationType;
		this.identificationNumber = identificationNumber;
	}


	public String getIdentificationType() {
		return identificationType;
	}


	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}


	public String getIdentificationNumber() {
		return identificationNumber;
	}


	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
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

	@Override
	public String toString() {
		return "Identification [id=" + id + ", photo=" + photo + ", attachment=" + attachment + ", identificationType="
				+ identificationType + ", identificationNumber=" + identificationNumber + "]";
	}

}
