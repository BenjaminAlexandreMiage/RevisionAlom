package alom.bank.server;

import java.util.Objects;

public class BankAccount {

	protected Client client;
	protected TypeAccount type;
	protected float money;
	
	public BankAccount(Client client, TypeAccount type) {
		this.client = client;
		this.type = type;
		this.money = 0;
	}
	
	public BankAccount() {}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public TypeAccount getType() {
		return type;
	}

	public void setType(TypeAccount type) {
		this.type = type;
	}
	
	public void addMoney(float money) {
		this.money = this.money + money;
	}

	public void withdrawMoney(float pullMoney) {
		this.money = this.money - pullMoney;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(client, money, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		return Objects.equals(client, other.client) &&  type == other.type;
	}
	
}
