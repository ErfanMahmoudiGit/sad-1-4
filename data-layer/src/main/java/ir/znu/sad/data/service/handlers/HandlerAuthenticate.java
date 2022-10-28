package ir.znu.sad.data.service.handlers;

import ir.znu.sad.data.Authenticator;
import ir.znu.sad.datatype.ui.Authentication;
import ir.znu.sad.utils.JsonTools;
import ir.znu.sad.utils.datatype.BaseResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("api/authenticate")
public class HandlerAuthenticate {

    @POST
    @Path("/user")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public String authorize(String authenticationJson) {
        return JsonTools.toJson(
                new BaseResult<>(Authenticator.authenticateUser(
                        JsonTools.fromJson(authenticationJson,Authentication.class))));
    }

}
