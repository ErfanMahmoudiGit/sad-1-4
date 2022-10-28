package ir.znu.sad.utils.clients;

import com.google.gson.reflect.TypeToken;
import ir.znu.sad.datatype.business.UserAuthenticationBusinessType;
import ir.znu.sad.datatype.data.Product;
import ir.znu.sad.datatype.data.UserAuthenticationType;
import ir.znu.sad.datatype.ui.Authentication;
import ir.znu.sad.utils.JsonTools;
import ir.znu.sad.utils.datatype.BaseResult;
import ir.znu.sad.utils.fetcher.PostGetClient;

import java.io.IOException;
import java.util.List;

public class BusinessClient extends PostGetClient {

    public BusinessClient(String ip, int port) {
        super(ip, port);
    }

    //Content-type:application/json
    public UserAuthenticationBusinessType authenticate(Authentication authentication) throws IOException {
        String jsonResult = postJsonParam("/api/authenticate/user", JsonTools.toJson(authentication));
        BaseResult<UserAuthenticationBusinessType> result = JsonTools.fromJson(jsonResult,
                new TypeToken<BaseResult<UserAuthenticationBusinessType>>() {});
        return result.getResult();
    }

    public List<Product> productTopView() throws IOException {
        String jsonResult = get("/api/product/top/view");
        BaseResult<List<Product>> result = JsonTools.fromJson(jsonResult,
                new TypeToken<BaseResult<List<Product>>>() {
                });
        return result.getResult();
    }
}
