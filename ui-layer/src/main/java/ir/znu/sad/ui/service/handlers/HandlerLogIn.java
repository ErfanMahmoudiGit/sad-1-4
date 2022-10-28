package ir.znu.sad.ui.service.handlers;

import ir.znu.sad.datatype.business.UserAuthenticationBusinessType;
import ir.znu.sad.datatype.ui.Authentication;
import ir.znu.sad.ui.authentication.UserAuthenticator;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/login")
public class HandlerLogIn {

    @GET
    @Produces("text/html;charset=utf-8")
    @Consumes("text/plain;charset=utf-8")
    public String login(@DefaultValue("") @QueryParam("message") String message){
        String htmlMessage = "<p>Click the \"Login\" button and the form-data will be sent to the authorization page. \n" +
                "</p>\n";

        if(!(message==null || message.equals(""))){
            htmlMessage = "<p><strong style=\"color: red;\">"+ message +
                    "</strong></p>\n";
        }

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Log in</h1>\n" +
                "\n" +
                "<form action=\"/login/authenticate\">\n" +
                "  <label for=\"username\">Username:</label>\n" +
                "  <input type=\"text\" id=\"username\" name=\"user\"><br><br>\n" +
                "  <label for=\"password\">Password:</label>\n" +
                "  <input type=\"password\" id=\"password\" name=\"pass\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Login\">\n" +
                "</form>\n" +
                "\n" +
                htmlMessage+
                "\n" +
                "</body>\n" +
                "</html>";
    }


    @GET
    @Path("/authenticate")
    @Produces("text/html;charset=utf-8")
    @Consumes("text/plain;charset=utf-8")
    public Response authenticate(@QueryParam("user") String user, //@DefaultValue("111")
                            @QueryParam("pass") String pass) throws URISyntaxException, IOException {
        if (user==null || pass==null)
            return Response.seeOther(new URI("/login?message=Null%20ERROR")).build();
        else if (user.length()==0 || pass.length()==0)
            return Response.seeOther(new URI("/login?message=length%20error")).build();
        UserAuthenticationBusinessType authResult = UserAuthenticator.authenticateUser(new Authentication(user, pass));
        if(authResult == UserAuthenticationBusinessType.OK){
            return Response.seeOther(new URI("/profile/"+user)).build();
        }
        else{
            return Response.seeOther(new URI("/login?message="+authResult.name())).build();
        }
    }
}
