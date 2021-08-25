package et.ticketingsystem.ts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@RequestMapping(path = "/tripPackage")
public class TripPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public enum ITEMCATEGOREY {
		FOOD("FD"), DRINK("DK"), BOOK("BK"), MOVIE("MV"), BED("BD"), LUGGAGE("LU");

		String code;

		private ITEMCATEGOREY(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

	@Column(name = "itemName")
	private String itemName;

	@Enumerated(EnumType.STRING)
	private ITEMCATEGOREY itemCategory;

	private int maxAllowed;

	private float maxWeightAllowed;

	private int maxNumAllowed;

	// @ManyToOne(fetch = FetchType.LAZY)
	// private Trip trip;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ITEMCATEGOREY getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ITEMCATEGOREY itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getMaxAllowed() {
		return maxAllowed;
	}

	public void setMaxAllowed(int maxAllowed) {
		this.maxAllowed = maxAllowed;
	}

	public float getMaxWeightAllowed() {
		return maxWeightAllowed;
	}

	public void setMaxWeightAllowed(int maxWeightAllowed) {
		this.maxWeightAllowed = maxWeightAllowed;
	}

	public int getMaxNumAllowed() {
		return maxNumAllowed;
	}

	public void setMaxNumAllowed(int maxNumAllowed) {
		this.maxNumAllowed = maxNumAllowed;
	}

	@Override
	public String toString() {
		return "TripPackage [id=" + id + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", maxAllowed="
				+ maxAllowed + ", maxWeightAllowed=" + maxWeightAllowed + ", maxNumAllowed=" + maxNumAllowed + "]";
	}

}
