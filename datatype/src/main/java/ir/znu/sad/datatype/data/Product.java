package ir.znu.sad.datatype.data;

public class Product {
    String name;
    String brand;
    int price;

    public Product(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}
