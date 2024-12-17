package alom.bank.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

import jakarta.jws.WebService;


public class bankImpl implements bank {

    protected Client client;
    protected BankAccount bankAccount;
    protected ArrayList<BankAccount> listeAccount;
    protected ArrayList<Client> listeClient;
    
    
    public bankImpl() {
		this.listeClient = new ArrayList<>();
		this.listeAccount = new ArrayList<>();
	}
  

	private boolean clientExists(String firstname, String lastname, Date date) {
    	Client nouveauClient = new Client(firstname,lastname,date);
    	if(this.listeClient.size()==0) {
    		return false;
    	}
    	else {
    		for (Client client : this.listeClient) {
    			if(client.equals(nouveauClient)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

	// Vérifie si un compte bancaire existe avec les informations données
    private boolean bankAccountExists(Client client, TypeAccount type) {
    	BankAccount nouveauCompte = new BankAccount(client,type);
    	if(this.listeAccount.size()==0) {
    		return false;
    	}
    	else {
    		for(BankAccount account : this.listeAccount) {
    			if(account.equals(nouveauCompte)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

    @Override
    public Client createClient(String firstname, String lastname, Date date) {
        if (this.clientExists(firstname, lastname, date)) {
            throw new NoSuchElementException("Client déjà existant");
        } else {
            Client client = new Client(firstname, lastname, date);
            this.listeClient.add(client);         
            return client;
        }
    }
    
    @Override
    public Client findClient(String firstname, String lastname, Date date) {
    	Client findclient = new Client(firstname,lastname,date);
        for(Client client : this.listeClient) {
        	if(client.equals(findclient)) {
        		return client;
        	}
        }
        throw new NoSuchElementException("Aucun client trouvé avec les informations données");
    }

    @Override
    public BankAccount createbankAccount(Client client, TypeAccount type) {
        if (!clientExists(client.getFirstname(), client.getLastname(), client.getDate())
            || bankAccountExists(client, type)) {
            throw new NoSuchElementException("Le client n'existe pas ou un compte existe déjà avec ce type de compte");
        } else {
        	BankAccount nouveauCompte = new BankAccount(client, type);
        	this.listeAccount.add(nouveauCompte);
            return nouveauCompte;
        }
    }

    @Override
    public BankAccount findBankAccount(Client client, TypeAccount type) {
        BankAccount findaccount = new BankAccount(client,type);
        for(BankAccount account : this.listeAccount) {
        	if(account.equals(findaccount)) {
        		return account;
        	}
        }
        throw new NoSuchElementException("Le compte bancaire n'existe pas ou le client n'existe pas");
    }

    @Override
    public float addMoneyAccount(BankAccount bankAccount, float amount) {
        if (!bankAccountExists(bankAccount.getClient(), bankAccount.getType()) || amount < 0) {
            throw new NoSuchElementException("Le compte n'existe pas ou la somme est incorrecte (doit être > 0)");
        } else {
           bankAccount.addMoney(amount);
            return bankAccount.getMoney();
        }
    }

    @Override
    public float getMonneyBankAccount(BankAccount bankAccount) {
        if (!bankAccountExists(bankAccount.getClient(), bankAccount.getType())) {
            throw new NoSuchElementException("Le compte n'existe pas");
        } else {
            return bankAccount.getMoney();
        }
    }

    @Override
    public float withdrawMoneyAccount(BankAccount bankAccount, float amount) {
        if (!bankAccountExists(bankAccount.getClient(), bankAccount.getType()) 
            || amount < 0 
            || (bankAccount.getMoney() - amount) < 0) {
            throw new NoSuchElementException("Le compte n'existe pas, la somme est incorrecte, ou découvert non autorisé");
        } else {
            bankAccount.withdrawMoney(amount);
            return bankAccount.getMoney();
        }
    }
    
    @Override
    public Client getClient() {
		return client;
	}

    @Override
	public void setClient(Client client) {
		this.client = client;
	}

    @Override
	public BankAccount getBankAccount() {
		return bankAccount;
	}

    @Override
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

    @Override
	public ArrayList getListeAccount() {
		return listeAccount;
	}

    @Override
	public void setListeAccount(ArrayList listeAccount) {
		this.listeAccount = listeAccount;
	}

    @Override
	public ArrayList<Client> getListeClient() {
		return listeClient;
	}

    @Override
	public void setListeClient(ArrayList<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public static void main(String[] args) {
    	
    	bankImpl bank = new bankImpl();
    	
    	try {
    		Client client1 = bank.createClient("Benjamin","ALEXANDRE",new Date(2024 - 1900, 8, 24));
    		BankAccount account1 = bank.createbankAccount(client1, TypeAccount.CHEQUES);
    		
    		
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    	
    	
    }
    

	
}

