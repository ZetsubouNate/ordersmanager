package model;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */

public class Product {
    private int id;
    private String product_name;
    private int quantity;
    private double price;

    public Product(String product_name, int quantity, double price) {
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id +
                ", '" + product_name +
                "', '" + quantity +
                "', " + price;
    }
}
