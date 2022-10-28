package ir.znu.sad.datatype.data;

import ir.znu.sad.datatype.business.UserAuthenticationBusinessType;

public enum UserAuthenticationType {
    OK,
    INVALID_USERNAME,
    INVALID_PASSWORD;

    public UserAuthenticationBusinessType getBusinessType(){
        switch (this){
            case OK: return UserAuthenticationBusinessType.OK;
            case INVALID_USERNAME: return UserAuthenticationBusinessType.INVALID_USERNAME;
            case INVALID_PASSWORD: return UserAuthenticationBusinessType.INVALID_PASSWORD;
            default: return null;
        }
    }
}
