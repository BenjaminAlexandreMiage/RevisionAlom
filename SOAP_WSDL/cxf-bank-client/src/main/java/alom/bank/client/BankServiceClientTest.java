package alom.bank.client;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;

import alom.bank.client.generated.Bank;
import alom.bank.client.generated.Client;
import alom.bank.client.generated.TypeAccount;

public class BankServiceClientTest {
	
	public static void main(String[] args) throws Exception {
		
	    BankServiceClient client = new BankServiceClient();
	    Bank service = client.getService();

	    GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime(Calendar.getInstance().getTime());

	    System.out.print("Création d'un client \n");

	    try {
	
	        Client client1 = service.createClient("Benjamin", "ALEXANDRE", DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
	        System.out.print("Création du client réussie : "+client1.getFirstname()+" "+client1.getLastname() + "\n");
	        
		    System.out.print("Création d'un compte \n");
		    service.createbankAccount(client1, TypeAccount.CHEQUES);
		    System.out.print("Création du compte réussie\n");
	    
	    } catch (Exception e) {
	        System.err.println("Erreur lors de la création du client : " + e.getMessage());
	        e.printStackTrace();  // Affichage détaillé de la trace
	    }
	}

}
