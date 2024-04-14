package a1704569.CardCollection.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardid;
	private String cardname;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="rarityid")
	private Rarity rarity;
	
	public Card() {}

	public Card( String cardname, String description, Rarity rarity) {
		super();
		this.cardname = cardname;
		this.description = description;
		this.rarity = rarity;
	}

	public void setCardid(long cardid) {
		this.cardid = cardid;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public long getCardid() {
		return cardid;
	}

	public String getCardname() {
		return cardname;
	}

	public String getDescription() {
		return description;
	}

	public Rarity getRarity() {
		return rarity;
	}

	@Override
	public String toString() {
		return "Card [cardid=" + cardid + ", cardname=" + cardname + ", description=" + description + ", rarity="
				+ rarity + "]";
	}
	
}
