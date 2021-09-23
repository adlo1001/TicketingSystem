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
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.RequestMapping;

@Entity
public class TripPackage {

	@Id
	@GeneratedValue
	private int id;

	public enum ITEMCATEGOREY {
		FOOD, DRINK, BOOK, MOVIE, BED, LUGGAGE;
	}

	private String itemName;

	@Enumerated(EnumType.STRING)
	private ITEMCATEGOREY itemCategory;

	private int maxAllowed;

	private float maxWeightAllowed;

	private int maxNumAllowed;	

	//@ManyToOne(fetch = FetchType.LAZY)
	//private Trip trip;

	public long getId() {
		return id;
	}

	public TripPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TripPackage(String itemName, ITEMCATEGOREY itemCategory, int maxAllowed, float maxWeightAllowed,
			int maxNumAllowed) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.maxAllowed = maxAllowed;
		this.maxWeightAllowed = maxWeightAllowed;
		this.maxNumAllowed = maxNumAllowed;
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

	public void setMaxWeightAllowed(float maxWeightAllowed) {
		this.maxWeightAllowed = maxWeightAllowed;
	}

	public int getMaxNumAllowed() {
		return maxNumAllowed;
	}

	public void setMaxNumAllowed(int maxNumAllowed) {
		this.maxNumAllowed = maxNumAllowed;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TripPackage [id=" + id + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", maxAllowed="
				+ maxAllowed + ", maxWeightAllowed=" + maxWeightAllowed + ", maxNumAllowed=" + maxNumAllowed + "]";
	}

	

}
