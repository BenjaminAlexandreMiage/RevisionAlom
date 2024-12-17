package alom.bank.server;

import java.util.Date;
import java.util.Objects;

public class Client {


	protected String firstname;
	protected String lastname; 
	protected Date date;
	
	public Client(String firstname, String lastname, Date date) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
	}
	
	public Client() {}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, firstname, lastname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(date, other.date) && Objects.equals(firstname, other.firstname)
				&& Objects.equals(lastname, other.lastname);
	}
	
}
