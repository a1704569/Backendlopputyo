package a1704569.CardCollection.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Rarity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long rarityid;
	private String rarityname;
	
	public Rarity() {}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rarity")
	private List<Card> cards;
	
	public Rarity(String rarityname) {
		super();
		this.rarityname = rarityname;
	}

	public void setRarityid(long rarityid) {
		this.rarityid = rarityid;
	}

	public void setRarityname(String rarityname) {
		this.rarityname = rarityname;
	}

	public long getRarityid() {
		return rarityid;
	}

	public String getRarityname() {
		return rarityname;
	}

	@Override
	public String toString() {
		return "Rarity [rarityid=" + rarityid + ", rarityname=" + rarityname + "]";
	}
	
	

}
