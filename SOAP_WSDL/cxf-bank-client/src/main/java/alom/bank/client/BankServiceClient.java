package alom.bank.client;

import java.util.Date;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import alom.bank.client.generated.Bank;
import alom.bank.client.generated.BankImplService;

public class BankServiceClient {

	private Bank service;

	public BankServiceClient() {
		
		JaxWsClientFactoryBean clientFactory = new JaxWsClientFactoryBean();
		ClientProxyFactoryBean factoryBean = new ClientProxyFactoryBean(clientFactory);
		
		factoryBean.setServiceClass(Bank.class);
		factoryBean.setAddress("http://localhost:8080/cxf-bank-server/cxf-bank-server/");
		
		this.service = (Bank) factoryBean.create();
		
		Client client = ClientProxy.getClient(this.service);
		
		HTTPConduit http = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = http.getClient ();
		
		httpClientPolicy.setConnectionTimeout(10000);
		httpClientPolicy.setReceiveTimeout(10000);
		
	}

	public Bank getService() {
		return this.service;
	}
	
}
