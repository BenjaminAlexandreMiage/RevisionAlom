package alom.bank.server;

import java.util.ArrayList;
import java.util.Date;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface bank {
	
	Client createClient(@WebParam(name="firstname") String firstname, @WebParam(name="lastname") String lastname,@WebParam(name="date") Date date);
	
	Client findClient(@WebParam(name="firstname") String firstname, @WebParam(name="lastname") String lastname,@WebParam(name="date") Date date);
	
	BankAccount  createbankAccount(@WebParam(name="client") Client client,@WebParam(name="typeAccount") TypeAccount type);
	
	BankAccount findBankAccount(@WebParam(name="client") Client client,@WebParam(name="typeAccount") TypeAccount type);
	
	float addMoneyAccount(@WebParam(name="bankAccount") BankAccount bankAccount,@WebParam(name="money") float addMoney );
	
	float getMonneyBankAccount(@WebParam(name="bankAccount") BankAccount bankAccount);
	
	float withdrawMoneyAccount(@WebParam(name="bankAccount") BankAccount bankAccount,@WebParam(name="money") float pullMoney );

	Client getClient();

	void setClient(Client client);

	BankAccount getBankAccount();

	void setBankAccount(BankAccount bankAccount);

	ArrayList<Client> getListeClient();

	void setListeClient(ArrayList<Client> listeClient);

	void setListeAccount(ArrayList listeAccount);

	ArrayList getListeAccount();
}
