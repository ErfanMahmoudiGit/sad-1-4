package ir.znu.sad.data;

import ir.znu.sad.data.mysql.MySQlTools;
import ir.znu.sad.datatype.data.UserAuthenticationType;
import ir.znu.sad.datatype.ui.Authentication;


public class Authenticator {

    public static UserAuthenticationType authenticateUser(Authentication authentication){
        if(MySQlTools.selectCount("select count(*) as count" +
                " from authentication" +
                " where username=\""+authentication.getUser()+"\" and " +
                " password=\""+authentication.getPass()+"\"")==1){
            return UserAuthenticationType.OK;
        }
        else if(MySQlTools.selectCount("select count(*) as count" +
                    " from authentication" +
                    " where username=\""+authentication.getUser()+"\"")==1){
                return UserAuthenticationType.INVALID_PASSWORD;
        }
        else {
            return UserAuthenticationType.INVALID_USERNAME;
        }
    }
}
