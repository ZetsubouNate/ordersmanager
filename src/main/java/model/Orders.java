package model;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */

public class Orders {
    private int id;
    private String client;
    private String product;
    private int quantity;

    public Orders() {}

    public Orders(String client, String product, int quantity) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id +
                ", '" + client +
                "', '" + product +
                "', " + quantity;
    }
}
