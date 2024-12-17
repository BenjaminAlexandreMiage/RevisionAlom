package alom.jersey_helloworld_client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {

	private String string;
	
	public Hello(String string) {
		super();
		this.string = string;
	}
	
	public Hello() {}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	
	
}