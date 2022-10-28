package ir.znu.sad.data.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class MainHandler {

    @GET
    @Produces("text/json;charset=utf-8")
    @Consumes("text/plain;charset=utf-8")
    public String mainPage(){
        return getMainPageJson();
    }

    public String getMainPageJson(){
        return "{\"ServiceName\": \"Data\"}";
    }
}
