package com.epam.models;

import com.epam.enums.Food;

public class Product {
    private int id;
    private String name;
    private int price;
    private int pizzeriaId;
    private Food productType;

    public Product() { }

    public Product(int id, String name, int price, int pizzeriaId, Food productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pizzeriaId = pizzeriaId;
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPizzeriaId() {
        return pizzeriaId;
    }

    public void setPizzeriaId(int pizzeriaId) {
        this.pizzeriaId = pizzeriaId;
    }

    public Food getProductType() {
        return productType;
    }

    public void setProductType(Food productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizzeriaId=" + pizzeriaId +
                ", productType=" + productType +
                '}';
    }
}
