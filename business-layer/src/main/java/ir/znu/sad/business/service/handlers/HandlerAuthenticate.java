package ir.znu.sad.business.service.handlers;

import ir.znu.sad.business.authentication.UserAuthenticator;
import ir.znu.sad.datatype.ui.Authentication;
import ir.znu.sad.utils.JsonTools;
import ir.znu.sad.utils.datatype.BaseResult;

import javax.ws.rs.*;
import java.io.IOException;

@Path("api/authenticate")
public class HandlerAuthenticate {

    @POST
    @Path("/user")
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public String authenticateUser(String authenticationJson) {
        try {
            return JsonTools.toJson(
                    new BaseResult<>(UserAuthenticator.authenticateUser(
                            JsonTools.fromJson(authenticationJson,Authentication.class))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
