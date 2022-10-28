package ir.znu.sad.business.service;

import ir.znu.sad.datatype.ServiceName;
import ir.znu.sad.utils.JsonTools;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class MainHandler {

    @GET
    @Produces("application/json;charset=utf-8")
    @Consumes("text/plain;charset=utf-8")
    public String mainPage(){
        return getMainPageJson();
    }

    public String getMainPageJson(){
        return JsonTools.toJson(new ServiceName("Business"));
    }
}
