package ir.znu.sad.ui;

import ir.znu.sad.datatype.data.Product;
import ir.znu.sad.utils.clients.BusinessClient;

import java.io.IOException;
import java.util.List;

public class MainPageManager {

    static BusinessClient businessClient = new BusinessClient("localhost",8001);

    public static List<Product> getTopViewedProducts() throws IOException {
        return businessClient.productTopView();
    }
}
