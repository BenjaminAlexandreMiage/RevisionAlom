package alom.jersey_helloworld_client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloWorldClient {
    
    // Attribut service de type WebResource
    private WebResource service;
    
    // Constructeur de la classe
    public HelloWorldClient() {
        // Créer un client Jersey avec la configuration par défaut
        Client client = Client.create(new DefaultClientConfig());
        
        // Affecter la ressource au service avec l'URL de la ressource
        this.service = client.resource("http://localhost:8080/jersey-helloworld-server/webapi/myresource");
    }
    
    
    public void callHello() {
        // Appeler la méthode hello() côté serveur
        String response = service.path("/hello") // Ajoute le chemin "hello"
                                .accept(MediaType.APPLICATION_JSON_TYPE) // Spécifie que l'on attend une réponse au format JSON
                                .get(String.class); // Effectue une requête GET et mappe la réponse en String
        
        // Afficher la réponse reçue du serveur
        System.out.println("Réponse du serveur : " + response);
    }
    
    
    public void callSayHello(String mess) {
        // Créer un objet Hello avec une chaîne
        Hello hello = new Hello();
        hello.setString(mess);

        // Appeler la méthode sayHello côté serveur
        Hello response = service.path("sayhello") // Indique la ressource "sayhello"
                                .type(MediaType.APPLICATION_JSON_TYPE) // Spécifie que nous envoyons du JSON
                                .post(Hello.class, hello); // Utilise la méthode POST pour envoyer l'objet Hello et mapper la réponse

        // Afficher la réponse
        System.out.println("Réponse du serveur : " + response.getString());
    }
    
    // Méthode main pour lancer l'application
    public static void main(String[] args) {
        // Créer une instance de HelloWorldClient
        HelloWorldClient client = new HelloWorldClient();
        
       client.callSayHello("world");;
    }
}
