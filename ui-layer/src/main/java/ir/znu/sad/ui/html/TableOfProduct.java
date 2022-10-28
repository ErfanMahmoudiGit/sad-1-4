package ir.znu.sad.ui.html;

import ir.znu.sad.datatype.data.Product;

import java.util.List;

public class TableOfProduct {

    public static Table getTable(String title,List<Product> products){
        Table<String> result = new Table<>(title,new String[]{
                "name","brand","price"
        });
        products.forEach(s -> result.addRow(new String[]{
                s.getName(),s.getBrand(),String.valueOf(s.getPrice())
        }));
        return result;
    }
}
