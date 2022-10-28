package ir.znu.sad.data.service.handlers;

import ir.znu.sad.data.product.ProductManager;
import ir.znu.sad.utils.JsonTools;
import ir.znu.sad.utils.datatype.BaseResult;

import javax.ws.rs.*;

@Path("api/product")
public class HandlerProduct {

    @GET
    @Path("/top10")
    @Produces("application/json;charset=utf-8")
//    @Consumes("application/json;charset=utf-8")
    public String getTop10() {
        return JsonTools.toJson(
                new BaseResult<>(ProductManager.getTop10()));
    }
}
