package ir.znu.sad.ui.service.handlers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/profile")
public class HandlerProfile {

    @GET
    @Path("/{user}")
    public String itemId(@PathParam("user") String user) {
        return "Profile path parameter value is [" + user + "]";
    }

}
