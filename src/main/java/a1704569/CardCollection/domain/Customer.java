package a1704569.CardCollection.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerid;
	private String firstname;
	private String surname;
	private String email;
	private String number;
	
	
public Customer() {}

@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
private List<Collection> collections;

	public Customer(String firstname, String surname, String email, String number) {
	super();
	this.firstname = firstname;
	this.surname = surname;
	this.email = email;
	this.number = number;
}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getCustomerid() {
		return customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", surname=" + surname + ", email=" + email
				+ ", number=" + number + "]";
	}


}
	
	
	


	


