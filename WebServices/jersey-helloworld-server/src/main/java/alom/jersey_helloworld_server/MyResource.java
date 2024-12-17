package alom.jersey_helloworld_server;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	@GET
	@Path("/hello")
	@Produces("application/json")
	public Hello hello() {
	     return new Hello("Hello");
	}
	
	@POST
    @Path("/sayhello")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayHello(Hello hello) {
        // Créer un nouvel objet Hello avec la chaîne modifiée
        Hello response = new Hello("Hello " + hello.getString());
        return response;     }
	
}
