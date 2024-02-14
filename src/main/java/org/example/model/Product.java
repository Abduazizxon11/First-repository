package org.example.model;

public class Product {


    private String name;
    private int ProductId;
    private double price;
    private String description;
    private String type;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ProductId=" + ProductId +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
