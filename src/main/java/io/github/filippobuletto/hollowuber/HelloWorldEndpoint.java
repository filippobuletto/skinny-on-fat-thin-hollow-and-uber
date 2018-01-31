package io.github.filippobuletto.hollowuber;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorldEndpoint {

  @GET
  @Produces("text/plain")
  public String doGet() {
    return "Hello from WildFly Swarm!";
  }
}
