package org.hello.world.monitor;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cars")
public class CarResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "cars resource counting test")
    public String init(){
        return "{\"hey\":\"listen\"}";
    }

}
