package ir.znu.sad.ui.authentication;

import ir.znu.sad.datatype.business.UserAuthenticationBusinessType;
import ir.znu.sad.datatype.ui.Authentication;
import ir.znu.sad.utils.clients.BusinessClient;
import ir.znu.sad.utils.clients.DataClient;

import java.io.IOException;

public class UserAuthenticator {

    static BusinessClient businessClient = new BusinessClient("localhost",8001);
    public static UserAuthenticationBusinessType authenticateUser(Authentication authentication) throws IOException {
        return businessClient.authenticate(authentication);
    }

}
