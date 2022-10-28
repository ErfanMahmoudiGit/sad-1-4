package ir.znu.sad.business.product;

import ir.znu.sad.datatype.data.Product;
import ir.znu.sad.utils.clients.DataClient;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class TopProductProvider {

    static DataClient dataClient = new DataClient("localhost",8002);

    public static List<Product> getTopViewedProduct() throws IOException {
        return rankByTodayView(dataClient.productTop10());
    }

    public static List<Product> rankByTodayView(List<Product> products){
        Collections.shuffle(products);
        return products;
    }
}
