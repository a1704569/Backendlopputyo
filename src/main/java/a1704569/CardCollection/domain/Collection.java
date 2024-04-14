package a1704569.CardCollection.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Collection {
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long collectionid;
	private String collectionname;
	private String collectiondescription;
	
	@ManyToOne
	@JoinColumn(name="cardid")
	private Card card;
	
	public Collection() {}

	public Collection(Customer customer, String collectionname, String collectiondescription, Card card) {
		super();
		this.customer = customer;
		this.collectionname = collectionname;
		this.collectiondescription = collectiondescription;
		this.card = card;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCollectionid(long collectionid) {
		this.collectionid = collectionid;
	}

	public void setCollectionname(String collectionname) {
		this.collectionname = collectionname;
	}

	public void setCollectiondescription(String collectiondescription) {
		this.collectiondescription = collectiondescription;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Customer getCustomer() {
		return customer;
	}

	public long getCollectionid() {
		return collectionid;
	}

	public String getCollectionname() {
		return collectionname;
	}

	public String getCollectiondescription() {
		return collectiondescription;
	}

	public Card getCard() {
		return card;
	}

	@Override
	public String toString() {
		return "Collection [customer=" + customer + ", collectionid=" + collectionid + ", collectionname="
				+ collectionname + ", collectiondescription=" + collectiondescription + ", card=" + card + "]";
	}
	
	

}
