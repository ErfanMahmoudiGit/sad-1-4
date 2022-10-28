package ir.znu.sad.data.product;

import ir.znu.sad.data.mysql.MySQlTools;
import ir.znu.sad.datatype.data.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {

    public static List<Product> getTop10(){
        return MySQlTools.selectTable("select * from product\n" +
                "order by price desc\n" +
                "limit 2",new String[]{"name","brand","price"})
                .getValues().stream().map(s ->
                        new Product(s[0],s[1],Integer.parseInt(s[2]) ))
                .collect(Collectors.toList());
    }
}
