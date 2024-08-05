package com.multi.web04_mvc2.dto;

public class ProductDto {
    private String id;
    private int price;
    private String name;

    @Override
    public String toString() {
        return "ProductVO{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
